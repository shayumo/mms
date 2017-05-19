package com.hiext.mms.admin.provider.impl;

import com.hiext.mms.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hiext.mms.admin.model.FCountRecord;
import com.hiext.mms.admin.provider.FCountRecordProvider;
import com.hiext.mms.admin.dao.FCountRecordDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * <br>
 * <b>功能：</b>FCountRecordProviderImpl<br>
 */
@Service
public class FCountRecordProviderImpl extends BaseServiceImpl<FCountRecordDao,FCountRecord> implements FCountRecordProvider {

    protected final Logger logger = LogManager.getLogger(this.getClass());
}
