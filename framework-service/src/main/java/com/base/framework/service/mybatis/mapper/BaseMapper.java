package com.base.framework.service.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;

/**
 * BaseMapper
 * @author zhouyw
 * @date 2018.04.17
 */
public interface BaseMapper<T> extends Mapper<T>,BaseInsertListMapper<T> {

}
