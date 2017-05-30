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

	private double s_amt;
	private double s_yezf;
	private double s_xjzf;
	private double s_xfzcs;

	public double getCountPoint() {
		return countPoint;
	}

	public void setCountPoint(double countPoint) {
		this.countPoint = countPoint;
	}

	public void transOf(FCountRecord fCount) {
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

	public double getS_amt() {
		return s_amt;
	}

	public void setS_amt(double s_amt) {
		this.s_amt = s_amt;
	}

	public double getS_yezf() {
		return s_yezf;
	}

	public void setS_yezf(double s_yezf) {
		this.s_yezf = s_yezf;
	}

	public double getS_xjzf() {
		return s_xjzf;
	}

	public void setS_xjzf(double s_xjzf) {
		this.s_xjzf = s_xjzf;
	}

	public double getS_xfzcs() {
		return s_xfzcs;
	}

	public void setS_xfzcs(double s_xfzcs) {
		this.s_xfzcs = s_xfzcs;
	}

}
