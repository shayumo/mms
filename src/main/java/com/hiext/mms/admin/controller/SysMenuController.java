package com.hiext.mms.admin.controller;

import com.hiext.mms.admin.model.SysMenu;
import com.hiext.mms.admin.sevice.MenuService;
import com.hiext.mms.core.HttpCode;
import com.hiext.mms.core.base.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * <br>
 * <b>功能：</b>SysMenuController<br>
 */
@RestController
@RequestMapping("/sysmenu")
@Api(value = "MenuApi", description = "菜单接口")
public class SysMenuController extends BaseController {
	
	@Autowired
	private MenuService menuService;
	
	@ApiOperation(value = "获取所有菜单", httpMethod = "POST")
	@PostMapping(value = "/list")
	public Object list(ModelMap modelMap){
		Subject currentUser = SecurityUtils.getSubject();
		boolean userRole=currentUser.hasRole("系统管理员");
		List<SysMenu> menus=menuService.menuByRole(userRole);
		return setModelMap(modelMap, HttpCode.OK, menus);
	}
 
}
