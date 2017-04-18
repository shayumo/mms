package com.hiext.mms.core.base.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

/**
 * 
 *
 * @remark 包含基础的单表增删改查、分页查询、按条件查询以及查询count
 */
public interface CurdService<T> {
	/**
	 * 根据ID删除数据,从数据库中删除
	 * 
	 * @param id
	 * @return
	 */
	int delete(Long id);

	/**
	 * 根据example条件删除数据
	 * 
	 * @param record
	 * @return
	 */
	int deleteByExample(Object example);

	/**
	 * 根据对象插入数据
	 * 
	 * @param record
	 * @return
	 */
	int insert(T record);

	/**
	 * 根据ID查找数据
	 * 
	 * @param id
	 * @return
	 */
	T selectByPrimaryKey(Long id);

	/**
	 * 根据对象更新数据,对象中ID必须存在
	 * 
	 * @param record
	 * @return
	 */
	int update(T record);

	/**
	 * 根据对example更新数据
	 * 
	 * @param record
	 * @param example
	 * @return
	 */
	int updateByExample(T record, Object example);

	/**
	 * 根据对象删除数据实际上是改了该条数据的datalevel, 该对象有且只能包含ID和datalevel两个属性
	 * 
	 * @param record
	 * @return
	 */
	int delete(T record);

	/**
	 * 传入example条件查询数据的count,关于example的使用 参考test目录中的测试
	 * 
	 * @param example
	 * @return
	 */
	Integer selectCountByExample(Object example);

	/**
	 * 传入example条件查询数据,关于example的使用 参考test目录中的测试
	 * 
	 * @param example
	 * @return
	 */
	List<T> selectAllByExample(Object example);

	/**
	 * 查询所有的记录
	 * 
	 * @return
	 */
	List<T> selectAll();

	/**
	 * 批量删除,根据逗号间隔传入的ID字符串删除数据
	 * 
	 * @param ids
	 * @return
	 */
	int deleteByIds(String ids);

	/**
	 * 分页查询,根据传入的example条件和rowBounnds 查询数据
	 * 
	 * @param example
	 * @param rowBounds
	 * @return
	 */
	List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);

	/**
	 * 
	 * @param record
	 * @param rowBounds
	 * @return
	 */
	List<T> selectByRowBounds(T record, RowBounds rowBounds);

	/**
	 * 根据model集合修改数据
	 * @param ids
	 * @return
	 */
	int updateByList(List<T> list);
	
	/**
	 * 根据model集合插入数据
	 * @param list
	 * @return
	 */
	int insertList(List<T> list);
	
	/**
	 * 根据id连接字符串查看数据
	 * @param ids
	 * @return
	 */
	List<T> selectByIds(String ids);

}
