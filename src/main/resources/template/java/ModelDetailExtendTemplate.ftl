package com.hiext.mms.${Base}.model.extend;

import com.hiext.mms.${Base}.model.${Begins}${BeanName};
import java.util.List;
import com.hiext.mms.${Base}.model.${Begins}${DetailName};

/**
 * 
 * <br>
 * <b>功能：</b>${BeanName}Extend<br>
 */
public class F${BeanName}Extend extends ${Begins}${BeanName} {

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
