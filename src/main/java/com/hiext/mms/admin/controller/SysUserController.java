package com.hiext.mms.admin.controller;

import com.hiext.mms.admin.model.SysUser;
import com.hiext.mms.admin.sevice.UserService;
import com.hiext.mms.core.HttpCode;
import com.hiext.mms.core.base.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

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
	
	@ApiOperation(value = "所有员工", httpMethod = "POST")
	@PostMapping(value = "/list")
	public Object list(ModelMap modelMap){
		SysUser user = new SysUser();
		user.setUserType((short) 2);
		List<SysUser> users=userService.list(user);
		return setModelMap(modelMap, HttpCode.OK, users);
	}
	@ApiOperation(value="新增用户",httpMethod="POST")
	@PostMapping(value="/addUser")
	@RequiresRoles(value="系统管理员")
	public Object add(ModelMap modelMap,@RequestBody SysUser user){
		if(user !=null){
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
}
