package com.hiext.mms.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiext.mms.admin.model.SysUser;
import com.hiext.mms.admin.model.SysUserRole;
import com.hiext.mms.admin.provider.SysUserProvider;
import com.hiext.mms.admin.provider.SysUserRoleProvider;
import com.hiext.mms.admin.sevice.UserService;

import tk.mybatis.mapper.entity.Example;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private SysUserProvider sysUserProvider;
	@Autowired
	private SysUserRoleProvider sysUserRoleProvider;

	@Override
	@Transactional
	public boolean addUser(SysUser user) {
		if(sysUserProvider.insertSelective(user)>0){
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setSysRoleId(3L);
			sysUserRole.setSysUserId(user.getId());
			sysUserRole.setCreatorid(user.getCreatorid());
			sysUserRole.setCreatorname(user.getCreatorname());
			sysUserRoleProvider.insertSelective(sysUserRole);
			return true;
		}
		return false;
	}

	@Override
	public SysUser editUser(SysUser user) {
		if(1==sysUserProvider.update(user)){
			return sysUserProvider.selectByPrimaryKey(user.getId());
		}
		return user;
	}

	@Override
	public List<SysUser> list(SysUser user) {
		Example example = new Example(SysUser.class);
		example.createCriteria().andCondition("datalevel<>-1 and User_Type=2");
		List<SysUser> users=sysUserProvider.selectAllByExample(example);
		return users;
	}

	@Override
	public SysUser queryByName(String name) {
		Example example = new Example(SysUser.class);
		example.createCriteria().andEqualTo("name", name);
		List<SysUser> users = sysUserProvider.selectAllByExample(example);
		if(users.size()>0){
			return users.get(0);
		}
		return new SysUser();
	}

}
