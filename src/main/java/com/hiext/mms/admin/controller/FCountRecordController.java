package com.hiext.mms.admin.controller;

import com.hiext.mms.admin.model.FCountRecord;
import com.hiext.mms.admin.model.FMember;
import com.hiext.mms.admin.model.extend.FCountRecordExtend;
import com.hiext.mms.admin.provider.FCountRecordProvider;
import com.hiext.mms.admin.provider.FMemberProvider;
import com.hiext.mms.admin.sevice.FCountRecordService;
import com.hiext.mms.core.HttpCode;
import com.hiext.mms.core.base.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tk.mybatis.mapper.entity.Example;

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
 * <b>功能：会员消费卡台账</b>FCountRecordController<br>
 */
@RestController
@RequestMapping("/fcountrecord")
@Api(value = "countApi", description = "会员消费台账接口")
public class FCountRecordController extends BaseController {
	@Autowired
	private FCountRecordService fCountRecordService;
	@Autowired
	private FMemberProvider fMemberProvider;
	@Autowired
	private FCountRecordProvider fCountRecordProvider;
	
	/**
	 * 会员充值 
	 * 充值逻辑：先判断会员当前的金额 再进行加上本次金额，同时更新 会员主表上的会员金额
	 * @param modelMap
	 * @param memberId
	 * @return
	 */
	@ApiOperation(value="会员卡充值",httpMethod="POST")
	@PostMapping(value="/add")
	public Object add(ModelMap modelMap,@RequestBody FCountRecord fCountRecord){
		if(fCountRecord!=null){
			
			fCountRecord.setCreatorid(getCurrUser().getId());
			fCountRecord.setCreatorname(getCurrUser().getName());
			if(fCountRecordService.add(fCountRecord)){
				return setMap(HttpCode.OK);
			}
			return setMap(HttpCode.BAD_REQUEST, "充值参数出错");
		}
		return setMap(HttpCode.BAD_REQUEST,"充值失败");
	}
	@ApiOperation(value="会员卡钱消费",httpMethod="POST")
	@PostMapping(value="/consumption")
	public Object consumption(ModelMap modelMap,@RequestBody FCountRecord fCountRecord){
		if(fCountRecord!=null){
			fCountRecord.setCreatorid(getCurrUser().getId());
			fCountRecord.setCreatorname(getCurrUser().getName());
			if(fCountRecordService.consumption(fCountRecord)){
				return setMap(HttpCode.OK);
			}
			return setMap(HttpCode.BAD_REQUEST, "消费参数出错");
		}
		return setMap(HttpCode.BAD_REQUEST,"消费失败");
	}
	/**
	 * 计算 折扣后的金额
	 * fcountRecord 必须传的参数 f_Member_id 然后金额用sum 字段
	 * @param modelMap
	 * @param fCountRecord
	 * @return
	 */
	@ApiOperation(value="获取折扣后的金额,详细说明看java代码注释",httpMethod="POST")
	@PostMapping(value="/getDiscount")
	public Object getDiscount(ModelMap modelMap,@RequestBody FCountRecord fCountRecord){
		if(fCountRecord!=null){
			if(fCountRecord.getfMemberId()!=null&&fCountRecord.getSum()!=null){
				double disCount=fCountRecordService.getDisNum(fCountRecord);
				return setMap(HttpCode.OK,disCount);
			}
			return setMap(HttpCode.BAD_REQUEST,"传参失败");
		}
		return setMap(HttpCode.BAD_REQUEST,"传参失败");
	}
	@ApiOperation(value="会员卡钱消费记录",httpMethod="POST")
	@PostMapping(value="/detil")
	public Object detil(ModelMap modelMap,String Tel){
		if(Tel!=null){
			Example example = new Example(FMember.class);
			example.createCriteria().andEqualTo("tel", Tel).andCondition("datalevel<> 2");
			List<FMember> fmen=fMemberProvider.selectAllByExample(example);
			if(fmen.size()>0){
				FMember fMember = fmen.get(0);
				List<FCountRecordExtend> counts=fCountRecordService.queryByMenid(fMember);
				return setMap(HttpCode.OK,counts);
			}else{
				return setMap(HttpCode.BAD_REQUEST,"请求失败");
			}
		}
		
		return setMap(HttpCode.BAD_REQUEST,"请求失败");
	}
	@ApiOperation(value="会员卡充值记录",httpMethod="POST")
	@PostMapping(value="/chongzhi")
	public Object chongzhidetil(ModelMap modelMap,Long fMenId){
		if(fMenId!=null){
			Example example = new Example(FCountRecord.class);
			example.createCriteria().andEqualTo("fMemberId", fMenId).andCondition("datalevel<>2 and count_type=0");
			List<FCountRecord> counts=fCountRecordProvider.selectAllByExample(example);
				return setMap(HttpCode.OK,counts);
			}else{
				return setMap(HttpCode.BAD_REQUEST,"请求失败");
			}
	}
}
