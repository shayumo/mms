package com.hiext.mms.admin.provider.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hiext.mms.admin.dao.FCountRecordDao;
import com.hiext.mms.admin.model.FCountRecord;
import com.hiext.mms.admin.model.extend.FCountRecordExtend;
import com.hiext.mms.admin.model.extend.FMemberExtend;
import com.hiext.mms.admin.provider.FCountRecordProvider;
import com.hiext.mms.core.base.service.impl.BaseServiceImpl;

/**
 * 
 * <br>
 * <b>功能：</b>FCountRecordProviderImpl<br>
 */
@Service
public class FCountRecordProviderImpl extends BaseServiceImpl<FCountRecordDao,FCountRecord> implements FCountRecordProvider {

    protected final Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public FCountRecordExtend xftj() {
		
		return dao.xftj();
	}



}
