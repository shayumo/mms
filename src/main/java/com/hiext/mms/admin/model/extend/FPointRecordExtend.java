package com.hiext.mms.admin.model.extend;

import com.hiext.mms.admin.model.FPointRecord;

/**
 * 
 * <br>
 * <b>功能：积分兑换</b>FPointRecordExtend<br>
 */
public class FPointRecordExtend extends FPointRecord {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//兑换产品的名称
	private String proName;
	//兑换礼品一共花费的积分
	private Double pointCount;
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Double getPointCount() {
		return pointCount;
	}
	public void setPointCount(Double pointCount) {
		this.pointCount = pointCount;
	}
}
