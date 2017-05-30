package com.hiext.mms.admin.provider;

import com.hiext.mms.admin.model.FCountRecord;
import com.hiext.mms.admin.model.extend.FCountRecordExtend;
import com.hiext.mms.core.base.service.BaseService;

/**
 * 
 * <br>
 * <b>功能：</b>FCountRecordProvider<br>
 */
public interface FCountRecordProvider extends BaseService<FCountRecord> {
	
	FCountRecordExtend xftj();
}
