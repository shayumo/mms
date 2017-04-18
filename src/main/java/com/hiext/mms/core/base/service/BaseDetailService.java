package com.hiext.mms.core.base.service;

/**
 * 
 * @author larry.liu
 *
 * @param <E>
 * @param <T>
 *
 * @date 2016年10月14日
 *
 * @remark 继承BaseService接口,同时提供处理主细表逻辑的接口,包含主细表同时新增、修改和查看
 */
public interface BaseDetailService<E> {
	/**
	 * 新增和修改的時候主細表一起提交
	 * 
	 * @param extend
	 */
	void masterDetailSave(E extend);

	/**
	 * 新增時主細起提交
	 * 
	 * @param extend
	 */
	void masterDetailAddSave(E extend);

	/**
	 * 修改或更新時主細一起提交
	 * 
	 * @param extend
	 */
	void masterDetailUpdateSave(E extend);

	/**
	 * 查看主表的一條数据
	 * 
	 * @param id
	 * @return
	 */
	E masterDetailView(Long id);

}
