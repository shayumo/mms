package com.hiext.mms.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiext.mms.admin.model.FCategory;
import com.hiext.mms.admin.model.FProduct;
import com.hiext.mms.admin.model.FVip;
import com.hiext.mms.admin.provider.FCategoryProvider;
import com.hiext.mms.admin.provider.FProductProvider;
import com.hiext.mms.admin.sevice.VipService;
import com.hiext.mms.core.HttpCode;
import com.hiext.mms.core.base.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tk.mybatis.mapper.entity.Example;
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
	
	@Autowired
	private VipService vipService;
	
	@Autowired
	private FCategoryProvider fCategoryProvider;
	
	@Autowired
	private FProductProvider fProductProvider;
	
	@ApiOperation(value = "等级列表", httpMethod = "POST")
	@PostMapping(value = "/viplist")
	public Object list(ModelMap modelMap) {
		List<FVip> vips=vipService.list();
		return setModelMap(modelMap, HttpCode.OK, vips);
	}
	@ApiOperation(value = "根据等级ID查询", httpMethod = "POST")
	@PostMapping(value = "/queryVip")
	public Object queryOne(ModelMap modelMap,@RequestBody Long id) {
		return setModelMap(modelMap, HttpCode.OK, vipService.queryOne(id));
	}
	@ApiOperation(value = "新增会员等级", httpMethod = "POST")
	@PostMapping(value = "/vipadd")
	public Object add(ModelMap modelMap,@RequestBody FVip vip) {
		Long ponit=vip.getPoint();
		Long num = vip.getDiscount();
		if(ponit <=100&&ponit>0){
			if(num<=100&&num>0){
				vip.setCreatorid(getCurrUser().getCreatorid());
				vip.setCreatorname(getCurrUser().getCreatorname());
				vipService.addVip(vip);
				return setSuccessMap();
			}	
		}
		return setModelMap(modelMap, HttpCode.OK, "参数出错");
	}
	@ApiOperation(value = "修改会员等级", httpMethod = "POST")
	@PostMapping(value = "/vipedit")
	public Object edit(ModelMap modelMap,@RequestBody FVip vip) {
		Long ponit=vip.getPoint();
		Long num = vip.getDiscount();
		if(ponit <=100&&ponit>0){
			if(num<=100&&num>0){
			vipService.editVip(vip);
			return setSuccessMap();
			}	
		}
		return setModelMap(modelMap, HttpCode.OK, "参数出错");
	}
	@ApiOperation(value = "删除会员等级", httpMethod = "POST")
	@PostMapping(value = "/vipdel")
	public Object del(ModelMap modelMap,@RequestBody Long id) {
		vipService.delVip(id);
		return setModelMap(modelMap, HttpCode.OK, "删除成功");
	}
	@ApiOperation(value = "分类列表", httpMethod = "POST")
	@PostMapping(value = "/categorylist")
	public Object listCata(ModelMap modelMap) {
		Example example = new Example(FCategory.class);
		example.createCriteria().andCondition("datalevel <> 1");
		List<FCategory> vips=fCategoryProvider.selectAllByExample(example);
		return setModelMap(modelMap, HttpCode.OK, vips);
	}
	@ApiOperation(value = "根据分类ID查询", httpMethod = "POST")
	@PostMapping(value = "/queryCategory")
	public Object queryOneCa(ModelMap modelMap,@RequestBody Long id) {
		return setModelMap(modelMap, HttpCode.OK, fProductProvider.selectByPrimaryKey(id));
	}
	@ApiOperation(value = "新增产品分类", httpMethod = "POST")
	@PostMapping(value = "/addCategory")
	public Object addCata(ModelMap modelMap,@RequestBody FCategory category) {
		category.setCreatorid(getCurrUser().getCreatorid());
		category.setCreatorname(getCurrUser().getCreatorname());
		fCategoryProvider.insertSelective(category);
		return setSuccessMap();
	}
	@ApiOperation(value = "修改产品分类", httpMethod = "POST")
	@PostMapping(value = "/editCategory")
	public Object editCata(ModelMap modelMap,@RequestBody FCategory category) {
		fCategoryProvider.update(category);
		return setSuccessMap();
	}
	@ApiOperation(value = "删除产品分类", httpMethod = "POST")
	@PostMapping(value = "/delCategory")
	public Object delCata(ModelMap modelMap,@RequestBody Long id) {
		FCategory category = new FCategory();
		category.setId(id);
		category.setDatalevel(1);
		fCategoryProvider.delete(category);
		return setModelMap(modelMap, HttpCode.OK, "删除成功");
	}
	
	@ApiOperation(value = "产品列表", httpMethod = "POST")
	@PostMapping(value = "/prolist")
	public Object listPro(ModelMap modelMap) {
		Example example = new Example(FProduct.class);
		example.createCriteria().andCondition("datalevel <> 1");
		List<FProduct> vips=fProductProvider.selectAllByExample(example);
		return setModelMap(modelMap, HttpCode.OK, vips);
	}
	@ApiOperation(value = "根据产品ID查询", httpMethod = "POST")
	@PostMapping(value = "/queryPro")
	public Object queryOnePro(ModelMap modelMap,@RequestBody Long id) {
		return setModelMap(modelMap, HttpCode.OK, fProductProvider.selectByPrimaryKey(id));
	}
	@ApiOperation(value = "新增产品", httpMethod = "POST")
	@PostMapping(value = "/addPro")
	public Object adPro(ModelMap modelMap,@RequestBody FProduct category) {
		category.setCreatorid(getCurrUser().getCreatorid());
		category.setCreatorname(getCurrUser().getCreatorname());
		fProductProvider.insertSelective(category);
		return setSuccessMap();
	}
	@ApiOperation(value = "修改产品", httpMethod = "POST")
	@PostMapping(value = "/editPro")
	public Object editPro(ModelMap modelMap,@RequestBody FProduct category) {
		fProductProvider.update(category);
		return setSuccessMap();
	}
	@ApiOperation(value = "删除产品", httpMethod = "POST")
	@PostMapping(value = "/delPro")
	public Object delPro(ModelMap modelMap,@RequestBody Long id) {
		FProduct category = new FProduct();
		category.setId(id);
		category.setDatalevel(1L);
		fProductProvider.delete(category);
		return setModelMap(modelMap, HttpCode.OK, "删除成功");
	}
}
