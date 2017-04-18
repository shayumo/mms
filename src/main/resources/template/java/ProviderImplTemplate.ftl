package com.ext.bp.${Base}.provider.impl;

import com.ext.bp.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.ext.bp.${Base}.model.${Begins}${BeanName};
import com.ext.bp.${Base}.provider.${BeanName}Provider;
import com.ext.bp.${Base}.dao.${Begins}${BeanName}Dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * <br>
 * <b>功能：</b>${BeanName}ProviderImpl<br>
 */
@Service
public class ${BeanName}ProviderImpl extends BaseServiceImpl<${Begins}${BeanName}Dao,${Begins}${BeanName}> implements ${BeanName}Provider {

    protected final Logger logger = LogManager.getLogger(this.getClass());
}
