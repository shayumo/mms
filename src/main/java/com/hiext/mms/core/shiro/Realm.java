package com.hiext.mms.core.shiro;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.hiext.mms.admin.model.SysRole;
import com.hiext.mms.admin.model.SysUser;
import com.hiext.mms.admin.model.SysUserRole;
import com.hiext.mms.admin.provider.SysRoleProvider;
import com.hiext.mms.admin.provider.SysUserProvider;
import com.hiext.mms.admin.provider.SysUserRoleProvider;
import com.hiext.mms.core.util.WebUtil;

import tk.mybatis.mapper.entity.Example;

/**
 * 权限检查
 * 
 * @author angy.zhang
 *
 */
public class Realm extends AuthorizingRealm {
	private final Logger logger = LogManager.getLogger();
	@Autowired
	private SysUserProvider sysUserProvider;
	@Autowired
	private SysUserRoleProvider sysUserRoleProvider;
	@Autowired
	private SysRoleProvider sysRoleProvider;

	/**
	 * 登录时将该记录登录人员的角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Long userId = (long) 0;
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				userId = (Long) session.getAttribute("accountId");
			}
		}
		SysUser sysUser=sysUserProvider.selectByPrimaryKey(userId);
		if (sysUser.getId() == null || "".equals(sysUser.getId())) {
			System.out.println("登录账号不存在");
		} else {
			Example accountRoleExample = new Example(SysUserRole.class);
			Example.Criteria criteria = accountRoleExample.createCriteria();
			criteria.andEqualTo("sysUserId", userId).andCondition("datalevel<>-1");
			List<SysUserRole> roleList = sysUserRoleProvider.selectAllByExample(accountRoleExample);

			for (SysUserRole userRole : roleList) {
				if (userRole.getSysRoleId() != null) {
					SysRole role = sysRoleProvider.selectByPrimaryKey(userRole.getSysRoleId());
					if (StringUtils.isNotBlank(role.getRoleName())) {
						System.out.println("我的角色有:" + role.getRoleName());
						info.addRole(role.getRoleName());
						info.addStringPermission(role.getRoleName());
					}
					/*Example authRoleExample = new Example(BAccountRole.class);
					Example.Criteria authRoleCriteria = authRoleExample.createCriteria();
					authRoleCriteria.andEqualTo("roleId", accountRole.getRoleId());
					List<BAuthRole> authList = authRoleProvider.selectAllByExample(authRoleExample);
					for (BAuthRole bAuthRole : authList) {
						if (bAuthRole.getAuthId() != null) {
							BAuth auth = authProvider.selectByPrimaryKey(bAuthRole.getAuthId());
							if (StringUtils.isNotBlank(auth.getAuthCode())) {
								System.out.println("我的权限有:" + auth.getAuthCode());
								info.addStringPermission(auth.getAuthCode());
							}
						}
					}*/
				}
			}
		}

		return info;
	}

	/**
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {

		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		System.out.println("account=" + token.getUsername());
		Example example = new Example(SysUser.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("account", token.getUsername());
		List<SysUser> list = sysUserProvider.selectAllByExample(example);
		if (list.size() == 1) {
			SysUser account = list.get(0);
			StringBuilder sb = new StringBuilder(100);
			for (int i = 0; i < token.getPassword().length; i++) {
				sb.append(token.getPassword()[i]);
			}
			if (account.getPassword().equals(sb.toString())) {
				WebUtil.saveCurrentUser(account);
				WebUtil.setSession("accountId", account.getId());
				// doGetAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
				AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(account.getAccount(), account.getPassword(),
						account.getAccount());
				return authcInfo;
			}
			logger.warn("用户名或者密码错误: {}", token.getUsername(), sb.toString());
			return null;
		} else {
			logger.warn("用户不存在: {}", token.getUsername());
			return null;
		}
	}
}
