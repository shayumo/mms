package com.ext.bp.${Base}.controller;

import com.ext.bp.core.base.controller.BaseController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * <br>
 * <b>功能：</b>${BeanName}Controller<br>
 */
@RestController
@RequestMapping("/${"${BeanName}"?lower_case}")
public class ${BeanName}Controller extends BaseController {
 
}
