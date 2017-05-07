package com.hiext.mms.admin.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiext.mms.core.HttpCode;
import com.hiext.mms.core.base.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 系统设置接口
 * 会员等级设置
 * @author angy.zhang
 *
 */
@RestController
@Api(value = "ConfigApi", description = "系统设置接口")
@RequestMapping("/config")
public class SysConfigController extends BaseController{
	
	@ApiOperation(value = "等级列表", httpMethod = "POST")
	@PostMapping(value = "/viplist")
	public Object list(ModelMap modelMap) {
		
		return setModelMap(modelMap, HttpCode.OK, 1);

	}
}
