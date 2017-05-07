package com.hiext.mms.admin.sevice;

import java.util.List;

import com.hiext.mms.admin.model.SysUser;

/**
 * 用户接口
 * @author angy.zhang
 *
 */
public interface UserService {
	/**
	 * 新增店员
	 * @param user
	 * @return
	 */
	public boolean addUser(SysUser user);
	/**
	 * 修改员工信息
	 * @param user
	 * @return
	 */
	public SysUser editUser(SysUser user);
	/**
	 * 查询员工列表 
	 * @param user
	 * @return
	 */
	public List<SysUser> list(SysUser user);
	/**
	 *	根据用户名查用户
	 * @param name
	 * @return
	 */
	public SysUser queryByName(String name);

}
