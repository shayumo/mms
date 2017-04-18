package com.ext.bp.${Base}.service.impl;

import com.ext.bp.core.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.ext.bp.${Base}.model.${Begins}${BeanName};
import com.ext.bp.${Base}.service.${BeanName}Service;
import com.ext.bp.${Base}.dao.${Begins}${DetailName}Dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.ext.bp.${Base}.model.extend.${Begins}${BeanName}Extend;
import com.ext.bp.${Base}.model.${Begins}${DetailName};
import java.util.List;
import tk.mybatis.mapper.entity.Example;	
import com.ext.bp.core.util.InstanceUtil;

/**
 * 
 * <br>
 * <b>功能：</b>${BeanName}ServiceImpl<br>
 */
@Service
public class ${BeanName}ServiceImpl extends BaseServiceImpl<${Begins}${BeanName}> implements ${BeanName}Service {

    protected final Logger logger = LogManager.getLogger(this.getClass());
    
    @Autowired
	private ${BeanName}Service ${"${BeanName}"?lower_case}Service;
    
    @Autowired
	private ${DetailName}Service ${"${DetailName}"?lower_case}Service;
    
    @Override
    @Transactional
	public void masterDetailSave(${Begins}${BeanName}Extend extend) {		
		if (extend.getId() == null) {
			this.masterDetailAddSave(extend);
		} else {
			this.masterDetailUpdateSave(extend);
		}
	}

	@Override
	@Transactional
	public void masterDetailAddSave(${Begins}${BeanName}Extend extend) {	
		${"${BeanName}"?lower_case}Service.insert(extend);
		Long id = extend.getId();
		List<${Begins}${DetailName}> list = extend.getList();
		if (list.size() > 0) {
			for (${Begins}${DetailName} o : list) {
				o.set${BeanKey}(id);
				o.setDatalevel((byte) 1);
				${"${DetailName}"?lower_case}Service.insert(o);
			}
		}
	}

	@Override
	@Transactional
	public void masterDetailUpdateSave(${Begins}${BeanName}Extend extend) {		
		${"${BeanName}"?lower_case}Service.update(extend);
		Long id = extend.getId();
		List<${Begins}${DetailName}> list = extend.getList();
		List<Long> idList = extend.getIdList();
		if (list.size() > 0) {
			for (${Begins}${DetailName} o : list) {
				if (o.getId() != null && o.getId() > 0) {
					${"${DetailName}"?lower_case}Service.update(o);
				} else {
					o.set${BeanKey}(id);
					o.setDatalevel((byte) 1);
					${"${DetailName}"?lower_case}Service.insert(o);
				}

			}
		}
		if (idList.size() > 0) {
			for (Long o : idList) {
				if (o != null && o > 0) {
					${"${DetailName}"?lower_case}Service.delete(o);
				}

			}

		}
	}

	@Override
	public ${Begins}${BeanName}Extend masterDetailView(Long id) {	
		${Begins}${BeanName} ${"${BeanName}"?lower_case}=${"${BeanName}"?lower_case}Service.selectByPrimaryKey(id);	
		Example example = new Example(${Begins}${DetailName}.class);
	    Example.Criteria criteria = example.createCriteria();
	    criteria.andEqualTo("${ForeignKey}", id);	
		List<B${DetailName}> list = ${"${DetailName}"?lower_case}Service.selectByExample(example);		
		${Begins}${BeanName}Extend extend = InstanceUtil.to(${"${BeanName}"?lower_case}, B${BeanName}Extend.class);
		extend.setList(list);
		return extend;
	}
}
