package com.hiext.mms.admin.provider.impl;

import com.hiext.mms.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hiext.mms.admin.model.FCategory;
import com.hiext.mms.admin.provider.FCategoryProvider;
import com.hiext.mms.admin.dao.FCategoryDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * <br>
 * <b>功能：</b>FCategoryProviderImpl<br>
 */
@Service
public class FCategoryProviderImpl extends BaseServiceImpl<FCategoryDao,FCategory> implements FCategoryProvider {

    protected final Logger logger = LogManager.getLogger(this.getClass());
}
