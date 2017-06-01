package com.hiext.mms.admin.sevice.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiext.mms.admin.model.FCountRecord;
import com.hiext.mms.admin.model.FMember;
import com.hiext.mms.admin.model.FPointRecord;
import com.hiext.mms.admin.model.FUserWages;
import com.hiext.mms.admin.model.FVip;
import com.hiext.mms.admin.model.extend.FCountRecordExtend;
import com.hiext.mms.admin.provider.FCountRecordProvider;
import com.hiext.mms.admin.provider.FPointRecordProvider;
import com.hiext.mms.admin.provider.FUserWagesProvider;
import com.hiext.mms.admin.provider.FVipProvider;
import com.hiext.mms.admin.provider.impl.FMemberProviderImpl;
import com.hiext.mms.admin.sevice.FCountRecordService;
import com.hiext.mms.core.util.GetDateTime;

import tk.mybatis.mapper.entity.Example;
@Service
public class FCountRecordServiceImpl implements FCountRecordService {
	@Autowired
	private FCountRecordProvider fCountRecordProvider;
	
	@Autowired
	private FMemberProviderImpl fMemberProviderImpl;
	
	@Autowired
	private FPointRecordProvider fPointRecordProvider;
	
	@Autowired
	private FVipProvider fVipProvider;
	@Autowired
	private FUserWagesProvider fUserWagesProvider;

	@Override
	@Transactional
	public Boolean add(FCountRecord fCountRecord) {
		if(fCountRecord!=null){
			if(fCountRecord.getfMemberId()!=null){
				FMember fMember = new FMember();
				fMember.setId(fCountRecord.getfMemberId());
				FMember fMember2=fMemberProviderImpl.selectByPrimaryKey(fCountRecord.getfMemberId());
				Double count = (fMember2.getCardMonery()!=null ? fMember2.getCardMonery():0);
				count = count+fCountRecord.getSum(); 
				fMember.setCardMonery(count);
				fMemberProviderImpl.update(fMember);
			}
			fCountRecord.setDatalevel(0);
			fCountRecord.setCreatedate(GetDateTime.getNowDate());
			fCountRecord.setCountType((short)0);
			fCountRecordProvider.insert(fCountRecord);
			return true;
		}
		return false;
	}
	@Override
	@Transactional
	public Boolean consumption(FCountRecord fCountRecord) {
		if(fCountRecord!=null){
			// 使用现金消费的金额
			double menery = 0;
			double cardMenery = 0;
			// 本次消费的总金额
			double sum = fCountRecord.getSum();
			// 卡类当前积分
			double cuPoint=0;
			
			// 积分换算比例
			double changerPonit = 0;
			
			FMember fMember = new FMember();
			FUserWages fUserWages = new FUserWages();
			fUserWages.setCreatorid(fCountRecord.getCreatorid());
			fUserWages.setCreatorname(fCountRecord.getCreatorname());
			fUserWages.setCreatedate(GetDateTime.getNowDate());
			fUserWages.setDatalevel(0l);
			fUserWages.setSysUserId(fCountRecord.getCreatorid());
			FPointRecord fPointRecord = new FPointRecord();
			fPointRecord.setDatalevel(0L);
			fPointRecord.setPointType(false);
			fPointRecord.setCreatorid(fCountRecord.getCreatorid());
			fPointRecord.setCreatorname(fCountRecord.getCreatorname());
			fPointRecord.setCreatedate(GetDateTime.getNowDate());
			fPointRecord.setfMemberId(fCountRecord.getfMemberId());
			if(fCountRecord.getfMemberId()!=null){
				//会员信息
				fMember=fMemberProviderImpl.selectByPrimaryKey(fCountRecord.getfMemberId());
				// 当前积分赋值
				cuPoint=(fMember.getfPointSum()!=null?fMember.getfPointSum():0);
				// 积分换算系数
				changerPonit=fVipProvider.selectByPrimaryKey(fMember.getfVipId()).getPoint();
				// 卡类余额
				cardMenery = fMember.getCardMonery();
				
			}else{
				return false;
			}
			if(fCountRecord.getPayType()!=null){
				switch (fCountRecord.getPayType()) {
				//会员卡内余额消费
				case 0:
					//判断卡类余额是否充足
					if((fMember.getCardMonery()!=null ? fMember.getCardMonery():0)>fCountRecord.getSum()){
						//减掉本次消费
						cardMenery = fMember.getCardMonery()-fCountRecord.getSum();
					}
					break;
				//会员现金消费
				case 1:
					menery=fCountRecord.getPayMonery();
					break;
				//两种方式
				case 2:
					menery=fCountRecord.getPayMonery();
					if(sum<=menery+cardMenery){
						//优先扣卡里的钱 默认是消费金额-现金
						cardMenery = fMember.getCardMonery()-(sum-menery);
					}else{
						return false;
					}
					break;
				default:
					break;
				}
				// 算积分
				cuPoint = cuPoint+changerPonit*sum;
				fPointRecord.setPoint(changerPonit*sum);
				fUserWages.setWages(sum*3/100);
				fUserWagesProvider.insert(fUserWages);
				fUserWagesProvider.update(fUserWages);
				//新增积分记录
				fPointRecordProvider.insert(fPointRecord);
				fPointRecordProvider.update(fPointRecord);
				fMember.setCardMonery(cardMenery);
				fMember.setfPointSum(cuPoint);
				fMemberProviderImpl.update(fMember);
				fCountRecord.setDatalevel(0);
				fCountRecord.setCountType((short)1);
				fCountRecord.setCreatedate(GetDateTime.getNowDate());
				fCountRecordProvider.insert(fCountRecord);
				fCountRecordProvider.update(fCountRecord);
				return true;
			}
			return false;
		}
		return false;
	}
	@Override
	public double getDisNum(FCountRecord fCountRecord) {
		if(fCountRecord!=null){
			FMember fMeber=fMemberProviderImpl.selectByPrimaryKey(fCountRecord.getfMemberId());
			double discount=fVipProvider.selectByPrimaryKey(fMeber.getfVipId()).getDiscount();
			return discount*fCountRecord.getSum()/100;
		}
		return 0;
	}
	@Override
	public List<FCountRecordExtend> queryByMenid(FMember men) {
		Example example = new Example(FCountRecord.class);
		example.createCriteria().andCondition("datalevel<>2").andEqualTo("fMemberId", men.getId()).andCondition("count_type=1");
		List<FCountRecord> fCountRecords=fCountRecordProvider.selectAllByExample(example);
		List<FCountRecordExtend> fExtends=new ArrayList<FCountRecordExtend>();
		FVip fVip=fVipProvider.selectByPrimaryKey(men.getfVipId());
		double point = fVip.getPoint();
		for (FCountRecord fCount : fCountRecords) {
			FCountRecordExtend e= new FCountRecordExtend(); 
			e.transOf(fCount);
			//计算积分
			double countPoint = point*fCount.getSum();
			e.setCountPoint(countPoint);
			fExtends.add(e);
		}
		return fExtends;
	}

}
