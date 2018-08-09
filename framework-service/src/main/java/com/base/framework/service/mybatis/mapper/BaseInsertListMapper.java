package com.base.framework.service.mybatis.mapper;

import com.base.framework.service.mybatis.mapper.special.BaseSpecialProvider;
import org.apache.ibatis.annotations.InsertProvider;

import java.util.List;

/**
 * BaseInsertListMapper
 * @author zhouyw
 * @date 2018.08.09
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface BaseInsertListMapper<T> {//InsertListMapper

    @InsertProvider(type = BaseSpecialProvider.class, method = "dynamicSQL")
    int insertList(List<T> recordList);
}
