package com.hiext.mms.admin.provider.impl;

import com.hiext.mms.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hiext.mms.admin.model.SysUserRole;
import com.hiext.mms.admin.provider.SysUserRoleProvider;
import com.hiext.mms.admin.dao.SysUserRoleDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * <br>
 * <b>功能：</b>SysUserRoleProviderImpl<br>
 */
@Service
public class SysUserRoleProviderImpl extends BaseServiceImpl<SysUserRoleDao,SysUserRole> implements SysUserRoleProvider {

    protected final Logger logger = LogManager.getLogger(this.getClass());
}
