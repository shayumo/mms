package com.hiext.mms.${Base}.controller;

import com.hiext.mms.core.base.controller.BaseController;
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
