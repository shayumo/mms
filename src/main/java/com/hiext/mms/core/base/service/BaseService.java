package com.hiext.mms.core.base.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;

/**
 *
 * @remark 作为一般业务逻辑的通用Service层接口,继承CurdService和SpecialService接口
 */
public interface BaseService<T> extends CurdService<T>{
	public PageInfo<T> query(Map<String,Object> params);
}
