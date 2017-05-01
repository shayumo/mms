package com.hiext.mms.admin.provider.impl;

import com.hiext.mms.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hiext.mms.admin.model.SysUser;
import com.hiext.mms.admin.provider.SysUserProvider;
import com.hiext.mms.admin.dao.SysUserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * <br>
 * <b>功能：</b>SysUserProviderImpl<br>
 */
@Service
public class SysUserProviderImpl extends BaseServiceImpl<SysUserDao,SysUser> implements SysUserProvider {

    protected final Logger logger = LogManager.getLogger(this.getClass());
}
