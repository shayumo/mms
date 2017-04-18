package com.ext.bp.${Base}.model.extend;

import com.ext.bp.${Base}.model.${Begins}${BeanName};
import java.util.List;
import com.ext.bp.${Base}.model.${Begins}${DetailName};

/**
 * 
 * <br>
 * <b>功能：</b>${BeanName}Extend<br>
 */
public class B${BeanName}Extend extends ${Begins}${BeanName} {

    private List<${Begins}${DetailName}> list;

	private List<Long> idList;	
	
	public List<${Begins}${DetailName}> getList() {
		return list;
	}

	public void setList(List<${Begins}${DetailName}> list) {
		this.list = list;
	}

	public List<Long> getIdList() {
		return idList;
	}

	public void setIdList(List<Long> idList) {
		this.idList = idList;
	}
  
}
