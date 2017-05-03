package com.hiext.mms.admin.provider.impl;

import com.hiext.mms.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.hiext.mms.admin.model.SysMenu;
import com.hiext.mms.admin.provider.SysMenuProvider;
import com.hiext.mms.admin.dao.SysMenuDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * <br>
 * <b>功能：</b>SysMenuProviderImpl<br>
 */
@Service
public class SysMenuProviderImpl extends BaseServiceImpl<SysMenuDao,SysMenu> implements SysMenuProvider {

    protected final Logger logger = LogManager.getLogger(this.getClass());
}
