package com.base.demo.service.common;

import com.base.demo.domain.ParamInfo;
import com.base.framework.common.exception.BusinessException;

import java.util.List;

/**
 * IParamInfoService
 * @author zhouyw
 * @date 2018.04.18
 */
public interface IParamInfoService {
    /**
     * 字典查询one
     * @param type 类别
     * @param code 字典码
     * @return
     * @throws BusinessException
     */
    ParamInfo getByTypeCode(String type,String code)throws BusinessException;

    /**
     * 字典查询list
     * @param type 类别
     * @return
     * @throws BusinessException
     */
    List<ParamInfo> getByType(String type)throws BusinessException;

    /**
     * 字典查询list
     * @param paramInfoVO
     * @return
     * @throws BusinessException
     */
    List<ParamInfo> getSubByTypeCode(String type,String code)throws BusinessException;

    /**
     * 查整个字典树
     * @param typeCode
     * @return
     * @throws BusinessException
     */
    List<ParamInfo> getTree(String type,String code)throws BusinessException;
}
