package com.hiext.mms.admin.sevice.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiext.mms.admin.model.SysMenu;
import com.hiext.mms.admin.model.SysRoleMenu;
import com.hiext.mms.admin.provider.SysMenuProvider;
import com.hiext.mms.admin.provider.SysRoleMenuProvider;
import com.hiext.mms.admin.sevice.MenuService;

import tk.mybatis.mapper.entity.Example;
@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	private SysRoleMenuProvider sysRoleMenuProvider;
	@Autowired
	private SysMenuProvider sysMenuProvider;

	@Override
	public List<SysMenu> menuByRole(boolean adminRole) {
		if(!adminRole){
			Example example = new Example(SysRoleMenu.class);
			example.createCriteria().andCondition("sys_role_id = 3 and datalevel<> -1");
			List<SysRoleMenu> roleMenus=sysRoleMenuProvider.selectAllByExample(example);
			List<SysMenu> sysMenu = new ArrayList<SysMenu>();
			for (SysRoleMenu sysRoleMenu : roleMenus) {
				sysMenu.add(sysMenuProvider.selectByPrimaryKey(sysRoleMenu.getSysMenuId()));
			}
			return sysMenu;
		}else{
			return sysMenuProvider.selectAll();
		}
	}

}
