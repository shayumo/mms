package com.hiext.mms.admin.controller;

import com.hiext.mms.admin.model.FPointRecord;
import com.hiext.mms.admin.model.extend.FPointRecordExtend;
import com.hiext.mms.admin.sevice.FPointService;
import com.hiext.mms.core.HttpCode;
import com.hiext.mms.core.base.controller.BaseController;
import com.hiext.mms.core.util.GetDateTime;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * <br>
 * <b>功能：会员积分管理</b>FPointRecordController<br>
 */
@RestController
@RequestMapping("/fpointrecord")
@Api(value = "pointApi", description = "会员积分台账接口")
public class FPointRecordController extends BaseController {
	@Autowired
	private FPointService fPointService;
	
	@ApiOperation(value="会员积分兑换",httpMethod="POST")
	@PostMapping(value="/duihuan")
	public Object duihuan(ModelMap modelMap,@RequestBody FPointRecord fPointRecord){
		modelMap.clear();
		if(fPointRecord!=null){
			fPointRecord.setCreatorid(getCurrUser().getId());
			fPointRecord.setCreatorname(getCurrUser().getName());
			fPointRecord.setCreatedate(GetDateTime.getNowDate());
			if(fPointService.duihuan(fPointRecord)){
				return setMap(HttpCode.OK);
			}
			return setMap(HttpCode.BAD_REQUEST, "积分兑换参数出错");
		}
		return setMap(HttpCode.BAD_REQUEST,"消费失败");
	}
	@ApiOperation(value="会员积分兑换列表",httpMethod="POST")
	@PostMapping(value="/list")
	public Object list(ModelMap modelMap,String tel){
		if(tel!=null){
			List<FPointRecordExtend> list=fPointService.list(tel);
			if(list!=null){
				return setMap(HttpCode.OK,list);
			}else{
				return setMap(HttpCode.BAD_REQUEST,"请求失败");
			}
		}
		return setMap(HttpCode.BAD_REQUEST,"消费失败");
	}
	@ApiOperation(value="获取兑换所需要的积分",httpMethod="POST")
	@PostMapping(value="/getCount")
	public Object getCount(ModelMap modelMap,@RequestBody FPointRecord fPointRecord){
		modelMap.clear();
		if(fPointRecord!=null){
			fPointRecord.setCreatorid(getCurrUser().getId());
			fPointRecord.setCreatorname(getCurrUser().getName());
			fPointRecord.setCreatedate(GetDateTime.getNowDate());
			double count=fPointService.check(fPointRecord);
			if(count!=0){
				return setMap(HttpCode.OK,count);
			}
		}
		return setMap(HttpCode.BAD_REQUEST,"兑换失败，可兑换的数量不对");
	}
}
