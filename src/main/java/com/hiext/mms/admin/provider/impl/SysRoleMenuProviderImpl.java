package com.hiext.mms.admin.provider.impl;

import com.hiext.mms.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hiext.mms.admin.model.SysRoleMenu;
import com.hiext.mms.admin.provider.SysRoleMenuProvider;
import com.hiext.mms.admin.dao.SysRoleMenuDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * <br>
 * <b>功能：</b>SysRoleMenuProviderImpl<br>
 */
@Service
public class SysRoleMenuProviderImpl extends BaseServiceImpl<SysRoleMenuDao,SysRoleMenu> implements SysRoleMenuProvider {

    protected final Logger logger = LogManager.getLogger(this.getClass());
}
