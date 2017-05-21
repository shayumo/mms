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

}
