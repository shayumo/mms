package com.hiext.mms.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiext.mms.admin.model.FVip;
import com.hiext.mms.admin.provider.FVipProvider;
import com.hiext.mms.admin.sevice.VipService;

import tk.mybatis.mapper.entity.Example;
@Service
public class VipServiceImpl implements VipService{
	
	@Autowired
	private FVipProvider fVipProvider;
	@Override
	public List<FVip> list() {
		Example example = new Example(FVip.class);
		example.createCriteria().andCondition("datalevel<>-1");
		return fVipProvider.selectAllByExample(example);
	}

	@Override
	public void addVip(FVip fVip) {
		fVipProvider.insertSelective(fVip);
		
	}

	@Override
	public void editVip(FVip fVip) {
		fVipProvider.update(fVip);
		
	}

	@Override
	public void delVip(Long id) {
		FVip vip = new FVip();
		vip.setId(id);
		vip.setDatalevel(1);
		fVipProvider.delete(vip);
	}

	@Override
	public FVip queryOne(Long id) {
		return fVipProvider.selectByPrimaryKey(id);
	}

}
