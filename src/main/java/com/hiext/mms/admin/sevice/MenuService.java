package com.hiext.mms.admin.sevice;

import java.util.List;

import com.hiext.mms.admin.model.SysMenu;
/**
 * 菜单接口
 * @author angy.zhang
 *
 */
public interface MenuService {
	
	List<SysMenu> menuByRole(boolean adminRole);

}
