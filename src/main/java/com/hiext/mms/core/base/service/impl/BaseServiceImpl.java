package com.hiext.mms.core.base.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hiext.mms.core.base.dao.BaseDao;
import com.hiext.mms.core.base.service.BaseService;
import com.hiext.mms.core.util.DataUtil;

/**
 * 
 * @author angy.zhang 修改日期：2016.11.1
 * @param <M>
 * @param <T>
 *
 *
 * @remark 对BaseService接口的通用实现,完成接口的实现过程,使用者继承该实现类即可完成通用功能 修改内容:新增緩存的查詢
 */
public class BaseServiceImpl<M extends BaseDao<T>, T> implements BaseService<T> {

	@Autowired
	protected M dao;

	@Transactional
	public int delete(Long id) {
		int count = 0;
		count = dao.deleteByPrimaryKey(id);
		return count;
	}

	@Transactional
	public int insert(T record) {
		return dao.insertUseGeneratedKeys(record);
	}

	public T selectByPrimaryKey(Long id) {
		return dao.selectByPrimaryKey(id);
	}

	@Transactional
	public int update(T record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	@Transactional
	public int delete(T record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	@Transactional
	public int deleteByIds(String ids) {
		return dao.deleteByIds(ids);
	}

	@Override
	public Integer selectCountByExample(Object example) {
		return dao.selectCountByExample(example);
	}

	@Override
	public List<T> selectAllByExample(Object example) {
		return dao.selectByExample(example);
	}

	@Override
	public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
		return dao.selectByExampleAndRowBounds(example, rowBounds);
	}

	@Override
	public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
		return dao.selectByRowBounds(record, rowBounds);
	}

	@Override
	public List<T> selectAll() {
		List<T> list = dao.selectAll();
		return list;
	}

	@Transactional
	public int deleteByExample(Object example) {
		return dao.deleteByExample(example);
	}

	@Transactional
	public int updateByExample(T record, Object example) {
		return dao.updateByExampleSelective(record, example);
	}

	@Override
	@Transactional
	public int updateByList(List<T> list) {
		int count = 0;
		for (T t : list) {
			int i = dao.updateByPrimaryKeySelective(t);
			if (0 != i) {
				count += 1;
			}
		}
		return count;
	}

	@Transactional
	public int insertList(List<T> recordList) {
		int count = 0;
		for (T t : recordList) {
			count += dao.insertUseGeneratedKeys(t);
		}
		return count;
	}

	@Override
	public List<T> selectByIds(String ids) {

		return dao.selectByIds(ids);
	}

	@Override
	public PageInfo<T> query(Map<String, Object> params) {
		if (DataUtil.isEmpty(params.get("pageNum"))) {
			params.put("pageNum", 1);
		}
		if (DataUtil.isEmpty(params.get("pageSize"))) {
			params.put("pageSize", 10);
		}
		if (DataUtil.isEmpty(params.get("orderBy"))) {
			params.put("orderBy", "id desc");
		}
		PageHelper.startPage(params);
		return null;
	}

}
