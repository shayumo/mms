package com.hiext.mms.admin.provider.impl;

import com.hiext.mms.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hiext.mms.admin.model.FMember;
import com.hiext.mms.admin.provider.FMemberProvider;
import com.hiext.mms.admin.dao.FMemberDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * <br>
 * <b>功能：</b>FMemberProviderImpl<br>
 */
@Service
public class FMemberProviderImpl extends BaseServiceImpl<FMemberDao,FMember> implements FMemberProvider {

    protected final Logger logger = LogManager.getLogger(this.getClass());
}
