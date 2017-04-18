package com.hiext.mms.core.base.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;

public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T>, DeleteByIdsMapper<T>,SelectByIdsMapper<T> {

}