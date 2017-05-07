package com.hiext.mms.admin.provider.impl;

import com.hiext.mms.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hiext.mms.admin.model.FProduct;
import com.hiext.mms.admin.provider.FProductProvider;
import com.hiext.mms.admin.dao.FProductDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * <br>
 * <b>功能：</b>FProductProviderImpl<br>
 */
@Service
public class FProductProviderImpl extends BaseServiceImpl<FProductDao,FProduct> implements FProductProvider {

    protected final Logger logger = LogManager.getLogger(this.getClass());
}
