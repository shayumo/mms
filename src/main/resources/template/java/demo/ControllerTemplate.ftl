package com.ext.bp.${Base}.controller;

import com.ext.bp.core.base.controller.BaseController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ext.bp.automanger.service.OrgService;
import org.springframework.ui.ModelMap;
import com.ext.bp.${Base}.model.${BeanName};
import com.ext.bp.${Base}.service.${BeanName}Service;
import javax.validation.Valid;

/**
 * 
 * <br>
 * <b>功能：</b>${BeanName}Controller<br>
 */
@RestController
@RequestMapping("/${"${BeanName}"?lower_case}")
public class ${BeanName}Controller extends BaseController {

    @Autowired
    private ${BeanName}Service ${"${BeanName}"?lower_case}Service; 
   
    @RequestMapping(value = "/list")
	public Object list() {
	  
	}	
	
	@RequestMapping(value = "/queryOne")
	public Object queryOne(Long id) {
	   if (result.hasErrors()) {
			Map<String, String> map = getErrors(result);
			return map;
		} else {
			// 继续业务逻辑
			System.out.println("成功了");
		}
	}
	
	@RequestMapping(value = "/add")
	public Object add(@RequestBody @Valid BOrg org, BindingResult result) {
	   if (result.hasErrors()) {
			Map<String, String> map = getErrors(result);
			return map;
		} else {
			// 继续业务逻辑
			System.out.println("成功了");
		}
	}
	
	@RequestMapping(value = "/edit")
	public Object edit(@RequestBody @Valid BOrg org, BindingResult result) {
	   if (result.hasErrors()) {
			Map<String, String> map = getErrors(result);
			return map;
		} else {
			// 继续业务逻辑
			System.out.println("成功了");
		}
	}
	
	@RequestMapping(value = "/delete")
	public Object delete(@RequestBody @Valid BOrg org, BindingResult result) {
	   if (result.hasErrors()) {
			Map<String, String> map = getErrors(result);
			return map;
		} else {
			// 继续业务逻辑
			System.out.println("成功了");
		}
	}
 
}
