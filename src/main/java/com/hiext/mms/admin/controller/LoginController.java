package com.hiext.mms.admin.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiext.mms.core.HttpCode;
import com.hiext.mms.core.base.controller.BaseController;
import com.hiext.mms.core.shiro.LoginHelper;
import com.hiext.mms.core.util.Assert;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @author larry.liu
 *
 *
 * @date 2016年10月20日 下午4:02:00
 * 
 * @remark 处理登录相关业务
 */
@RestController
@Api(value = "LoginApi", description = "登陆接口")
@RequestMapping("/login")
public class LoginController extends BaseController {

	/**
	 * 登录验证
	 * 
	 * @param modelMap
	 * @param account
	 * @param password
	 * @return
	 */

	@ApiOperation(value = "用户登陆", httpMethod = "POST")
	@PostMapping(value = "/login")
	public Object login(ModelMap modelMap,
			@ApiParam(value = "登陆账号", required = true) @RequestParam("account") String account,
			@ApiParam(value = "登陆密码", required = true) @RequestParam("password") String password) {
		Assert.isNotBlank(password, "PASSWORD");
		if (LoginHelper.login(account, password)) {
			return setSuccessModelMap(modelMap,getCurrUser().getUserType());
		}
		return setMap(HttpCode.LOGIN_FAIL);

	}

	/**
	 * 登录超时或者没有登录自动调用该方法
	 * 
	 * @param modelMap
	 * @return
	 */
	@ApiOperation(value = "没有登陆")
	@RequestMapping(value = "/unauthorized")
	public Object unauthorized(ModelMap modelMap) {
		return setModelMap(modelMap, HttpCode.LOGIN_TIMEOUT);

	}

	/**
	 * 权限不足时自动调用该方法
	 * 
	 * @param modelMap
	 * @return
	 */
	@ApiOperation(value = "用户权限不足")
	@RequestMapping(value = "/forbidden")
	public Object forbidden(ModelMap modelMap) {
		return setModelMap(modelMap, HttpCode.FORBIDDEN);

	}

	@ApiOperation(value = "登出系统", httpMethod = "POST")
	@PostMapping(value = "logout")
	public Object logout(ModelMap modelMap) {
		SecurityUtils.getSubject().logout();
		return setModelMap(modelMap, HttpCode.OK);
	}

}
