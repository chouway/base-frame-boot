package com.base.demo.service.common.dao;

import com.base.demo.domain.ParamInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ParamInfoExtService
 * @author zhouyw
 * @date 2018.04.19
 */
@Mapper
public interface ParamInfoDaoExt {
    /**
     * 获取某个字典下所有的子字典
     * @param type
     * @param code
     * @return
     */
    List<ParamInfo> getTree(@Param("type") String type, @Param("code")String code);

}
