package com.hiext.mms.admin.model.extend;

import com.hiext.mms.admin.model.SysUser;

/**
 * 
 * <br>
 * <b>功能：</b>SysUserExtend<br>
 */
public class SysUserExtend extends SysUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Double wages;

	public Double getWages() {
		return wages;
	}

	public void setWages(Double wages) {
		this.wages = wages;
	}
	
}
