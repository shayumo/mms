package com.hiext.mms.admin.provider.impl;

import com.hiext.mms.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hiext.mms.admin.model.FUserWages;
import com.hiext.mms.admin.provider.FUserWagesProvider;
import com.hiext.mms.admin.dao.FUserWagesDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * <br>
 * <b>功能：</b>FUserWagesProviderImpl<br>
 */
@Service
public class FUserWagesProviderImpl extends BaseServiceImpl<FUserWagesDao,FUserWages> implements FUserWagesProvider {

    protected final Logger logger = LogManager.getLogger(this.getClass());
}
