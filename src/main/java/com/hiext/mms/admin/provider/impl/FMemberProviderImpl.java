package com.hiext.mms.admin.provider.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hiext.mms.admin.dao.FMemberDao;
import com.hiext.mms.admin.model.FMember;
import com.hiext.mms.admin.model.extend.FMemberExtend;
import com.hiext.mms.admin.provider.FMemberProvider;
import com.hiext.mms.core.base.service.impl.BaseServiceImpl;

/**
 * 
 * <br>
 * <b>功能：</b>FMemberProviderImpl<br>
 */
@Service
public class FMemberProviderImpl extends BaseServiceImpl<FMemberDao,FMember> implements FMemberProvider {

    protected final Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public FMemberExtend hytj() {
		
		return dao.hytj();
	}
    
}
