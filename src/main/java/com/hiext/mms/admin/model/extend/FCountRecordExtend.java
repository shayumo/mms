package com.hiext.mms.admin.model.extend;

import com.hiext.mms.admin.model.FCountRecord;

/**
 * 
 * <br>
 * <b>功能：</b>FCountRecordExtend<br>
 */
public class FCountRecordExtend extends FCountRecord {
	private static final long serialVersionUID = 1L;
	/**
	 * 消费对应的积分
	 */
	private double countPoint;
	public double getCountPoint() {
		return countPoint;
	}
	public void setCountPoint(double countPoint) {
		this.countPoint = countPoint;
	}
	
	public void transOf(FCountRecord fCount){
		this.setCountType(fCount.getCountType());
		this.setCreatedate(fCount.getCreatedate());
		this.setCreatorid(fCount.getCreatorid());
		this.setCreatorname(fCount.getCreatorname());
		this.setDatalevel(fCount.getDatalevel());
		this.setfMemberId(fCount.getfMemberId());
		this.setId(fCount.getId());
		this.setPayMonery(fCount.getPayMonery());
		this.setPayType(fCount.getPayType());
		this.setRemark(fCount.getRemark());
		this.setSum(fCount.getSum());
	}

}
