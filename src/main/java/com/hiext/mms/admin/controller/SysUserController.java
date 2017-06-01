package com.hiext.mms.admin.controller;

import com.hiext.mms.admin.model.FUserWages;
import com.hiext.mms.admin.model.SysUser;
import com.hiext.mms.admin.model.extend.SysUserExtend;
import com.hiext.mms.admin.provider.FUserWagesProvider;
import com.hiext.mms.admin.provider.SysUserProvider;
import com.hiext.mms.admin.sevice.UserService;
import com.hiext.mms.core.HttpCode;
import com.hiext.mms.core.base.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tk.mybatis.mapper.entity.Example;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * <br>
 * <b>功能：</b>SysUserController<br>
 */
@RestController
@Api(value = "UserApi", description = "员工管理接口")
@RequestMapping("/sysuser")
public class SysUserController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private SysUserProvider sysUserProvider;
	@Autowired
	private FUserWagesProvider fUserWagesProvider;
	
	@ApiOperation(value = "所有员工", httpMethod = "POST")
	@PostMapping(value = "/list")
	public Object list(ModelMap modelMap){
		SysUser user = new SysUser();
		user.setUserType((short) 2);
		List<SysUser> users=userService.list(user);
		List<SysUserExtend> us = new ArrayList<SysUserExtend>();
		
		for (SysUser sysUser : users) {
			SysUserExtend sysUserEx = new SysUserExtend();
			sysUserEx.setAccount(sysUser.getAccount());
			sysUserEx.setAddress(sysUser.getAddress());
			sysUserEx.setId(sysUser.getId());
			sysUserEx.setName(sysUser.getName());
			sysUserEx.setPassword(sysUser.getPassword());
			sysUserEx.setPhone(sysUser.getPhone());
			sysUserEx.setSex(sysUser.getSex());
			sysUserEx.setOrderno(sysUser.getOrderno());
			sysUserEx.setEmail(sysUser.getEmail());
			us.add(sysUserEx);
		}
		for (SysUserExtend sysUserExtend : us) {
			double count = 0;
			Example example = new Example(FUserWages.class);
			example.createCriteria().andEqualTo("sysUserId", sysUserExtend.getId());
			List<FUserWages> f=fUserWagesProvider.selectAllByExample(example);
			if(f.size()>0){
				double wages= 0;
				for (FUserWages fUserWages : f) {
					wages=((fUserWages.getWages()==null||fUserWages.getWages()==0)?0:fUserWages.getWages());
					count+=wages;
				}
			}
			sysUserExtend.setWages(count);
		}
		return setModelMap(modelMap, HttpCode.OK, us);
	}
	@ApiOperation(value="新增用户",httpMethod="POST")
	@PostMapping(value="/addUser")
	@RequiresRoles(value="系统管理员")
	public Object add(ModelMap modelMap,@RequestBody SysUser user){
		if(user !=null){
			user.setUserType((short) 2);
			user.setCreatorname(getCurrUser().getName());
			user.setCreatorid(getCurrUser().getId());
			userService.addUser(user);
			return setMap(HttpCode.OK);
		}
		return setSuccessMap("请填写用户信息");
	}
	@ApiOperation(value="修改员工",httpMethod="POST")
	@RequestMapping("updateUser")
	@RequiresRoles(value="系统管理员")
	public Object update(ModelMap modelMap,@RequestBody SysUser user){
		if(user !=null){
			userService.editUser(user);
			return setMap(HttpCode.OK);
		}
		return setSuccessMap();
	}
	
	@ApiOperation(value = "查询员工", httpMethod = "POST")
	@PostMapping(value = "/queryOne")
	public Object query(ModelMap modelMap,Long id){
		return setModelMap(modelMap, HttpCode.OK, sysUserProvider.selectByPrimaryKey(id));
	}
	
	@ApiOperation(value = "删除员工", httpMethod = "POST")
	@PostMapping(value = "/del")
	public Object del(ModelMap modelMap,Long id){
		SysUser sysUser = new SysUser();
		sysUser.setId(id);
		sysUser.setDatalevel(1);
		sysUserProvider.delete(sysUser);
		return setModelMap(modelMap, HttpCode.OK, "删除成功");
	}
}
