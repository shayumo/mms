package com.hiext.mms.admin.sevice;

import java.util.List;

import com.hiext.mms.admin.model.FVip;

/**
 * 会员等级初始设置
 * @author angy.zhang
 *
 */
public interface VipService {
	
	public List<FVip> list();
	
	public void addVip(FVip fVip);
	
	public void editVip(FVip fVip);
	
	public void delVip(Long id);
	
	public FVip queryOne(Long id);
}
