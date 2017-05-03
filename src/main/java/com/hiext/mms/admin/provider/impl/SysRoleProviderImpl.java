package com.hiext.mms.admin.provider.impl;

import com.hiext.mms.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hiext.mms.admin.model.SysRole;
import com.hiext.mms.admin.provider.SysRoleProvider;
import com.hiext.mms.admin.dao.SysRoleDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * <br>
 * <b>功能：</b>SysRoleProviderImpl<br>
 */
@Service
public class SysRoleProviderImpl extends BaseServiceImpl<SysRoleDao,SysRole> implements SysRoleProvider {

    protected final Logger logger = LogManager.getLogger(this.getClass());
}
