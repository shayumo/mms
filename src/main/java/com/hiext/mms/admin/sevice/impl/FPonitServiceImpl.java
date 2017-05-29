package com.hiext.mms.admin.sevice.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiext.mms.admin.model.FMember;
import com.hiext.mms.admin.model.FPointRecord;
import com.hiext.mms.admin.model.FProduct;
import com.hiext.mms.admin.model.extend.FPointRecordExtend;
import com.hiext.mms.admin.provider.FMemberProvider;
import com.hiext.mms.admin.provider.FPointRecordProvider;
import com.hiext.mms.admin.provider.FProductProvider;
import com.hiext.mms.admin.sevice.FPointService;

import tk.mybatis.mapper.entity.Example;
@Service
public class FPonitServiceImpl implements FPointService {
	@Autowired
	private FPointRecordProvider fPointRecordProvider;
	@Autowired
	private FProductProvider fProductProvider;
	@Autowired
	private FMemberProvider fMemberProvider;

	@Override
	@Transactional
	public Boolean duihuan(FPointRecord fPointRecord) {
		//设置成兑换的类型
		fPointRecord.setPointType(true);
		fPointRecord.setDatalevel(0L);
		if(fPointRecord.getfMemberId()==null||fPointRecord.getfMemberId()==0){
			return false;
		}
		if(fPointRecord.getfProductId()==null||fPointRecord.getfProductId()==0){
			return false;
		}
		FProduct fProduct = fProductProvider.selectByPrimaryKey(fPointRecord.getfProductId());
		//获取会员信息
		FMember fMember=fMemberProvider.selectByPrimaryKey(fPointRecord.getfMemberId());
		//获取会员当前的积分
		double cuPoint=fMember.getfPointSum();
		double countPoint=check(fPointRecord);
		if(countPoint!=0){
			//插入一条台账
			fPointRecordProvider.insert(fPointRecord);
			//减掉积分
			fMember.setfPointSum(cuPoint-countPoint);
			Long nowNum = (long) (fProduct.getNum()-fPointRecord.getCount());
			//减去礼品数量
			fProduct.setNum(nowNum);
			fProductProvider.update(fProduct);
			//更新会员的当前积分
			fMemberProvider.update(fMember);
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public Double check(FPointRecord fPointRecord) {
		if(fPointRecord.getfMemberId()==null||fPointRecord.getfMemberId()==0){
			return (double) 0;
		}
		if(fPointRecord.getfProductId()==null||fPointRecord.getfProductId()==0){
			return (double) 0;
		}
		//判断数量不能为空
		if(fPointRecord.getCount()==null||fPointRecord.getCount()==0){
			return (double) 0;
		}
		FProduct fProduct = fProductProvider.selectByPrimaryKey(fPointRecord.getfProductId());
		//获取每个礼品所系要的积分
		Long point =fProduct.getPoint();
		//获取会员信息
		FMember fMember=fMemberProvider.selectByPrimaryKey(fPointRecord.getfMemberId());
		//获取会员当前的积分
		double cuPoint=fMember.getfPointSum();
		//设置积分兑换的每个产品的积分
		fPointRecord.setPoint((double)point);
		//计算兑换礼品 所需要总的积分
		double countPoint = point*fPointRecord.getCount();
		if(cuPoint>=countPoint&&fProduct.getNum()>=fPointRecord.getCount()){
			return countPoint;
		}else{
			return (double) 0;
		}
	}

	@Override
	public List<FPointRecordExtend> list(String tel) {
		Example example = new Example(FMember.class);
		example.createCriteria().andEqualTo("tel", tel).andCondition("datalevel<> 2");
		List<FMember> fmen=fMemberProvider.selectAllByExample(example);
		if(fmen.size()>0){
			FMember fMember=fmen.get(0);
			Long fMeId=fMember.getId();
			Example example2 = new Example(FPointRecord.class);
			example2.createCriteria().andCondition("datalevel<>2").andEqualTo("fMemberId", fMeId).andCondition("point_type=1");
			List<FPointRecord> list=fPointRecordProvider.selectAllByExample(example2);
			List<FPointRecordExtend> list2 = new ArrayList<>();
			FPointRecordExtend fPointRecordExtend = new FPointRecordExtend();
			if(list!=null&&list.size()>0){
				for (FPointRecord fPointRecord : list) {
					Long proId=fPointRecord.getfProductId();
					FProduct fProduct=fProductProvider.selectByPrimaryKey(proId);
					fPointRecordExtend.setProName(fProduct.getName());
					fPointRecordExtend.setCreatedate(fPointRecord.getCreatedate());
					fPointRecordExtend.setCount(fPointRecord.getCount());
					fPointRecordExtend.setPointCount(fPointRecord.getCount()*fProduct.getPoint());
					list2.add(fPointRecordExtend);
				}	
			}else{
				return null;
			}
			return list2;
		}
		return null;
	}

}
