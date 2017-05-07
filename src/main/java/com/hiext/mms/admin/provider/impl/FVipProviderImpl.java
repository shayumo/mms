package com.hiext.mms.admin.provider.impl;

import com.hiext.mms.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hiext.mms.admin.model.FVip;
import com.hiext.mms.admin.provider.FVipProvider;
import com.hiext.mms.admin.dao.FVipDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * <br>
 * <b>功能：</b>FVipProviderImpl<br>
 */
@Service
public class FVipProviderImpl extends BaseServiceImpl<FVipDao,FVip> implements FVipProvider {

    protected final Logger logger = LogManager.getLogger(this.getClass());
}
