package com.hiext.mms.admin.provider.impl;

import com.hiext.mms.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hiext.mms.admin.model.FPointRecord;
import com.hiext.mms.admin.provider.FPointRecordProvider;
import com.hiext.mms.admin.dao.FPointRecordDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * <br>
 * <b>功能：</b>FPointRecordProviderImpl<br>
 */
@Service
public class FPointRecordProviderImpl extends BaseServiceImpl<FPointRecordDao,FPointRecord> implements FPointRecordProvider {

    protected final Logger logger = LogManager.getLogger(this.getClass());
}
