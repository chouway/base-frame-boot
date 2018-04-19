package com.base.demo.service.common;

import com.base.demo.dao.ParamInfoDao;
import com.base.demo.service.common.dao.ParamInfoDaoExt;
import com.base.demo.domain.ParamInfo;
import com.base.framework.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ParamInfoService
 * @author zhouyw
 * @date 2018.04.18
 */
@Service
@Transactional
public class ParamInfoService implements IParamInfoService {

    @Autowired
    private ParamInfoDao paramInfoDao;

    @Autowired
    private ParamInfoDaoExt paramInfoDaoExt;

    @Override
    public ParamInfo getByTypeCode(String type,String code) throws BusinessException {
        if(StringUtils.isEmpty(type)){
            throw new BusinessException("字典类别为空");
        }
        if(StringUtils.isEmpty(code)){
            throw new BusinessException("字典码为空");
        }
        ParamInfo paramInfo = new ParamInfo();
        paramInfo.setType(type);
        paramInfo.setCode(code);
        return paramInfoDao.selectOne(paramInfo);
    }

    @Override
    public List<ParamInfo> getByType(String type) throws BusinessException {
        if(StringUtils.isEmpty(type)){
            throw new BusinessException("字典类别为空");
        }
        ParamInfo paramInfo = new ParamInfo();
        paramInfo.setType(type);
        return paramInfoDao.select(paramInfo);
    }

    @Override
    public List<ParamInfo> getSubByTypeCode(String type, String code) throws BusinessException {
        ParamInfo paramInfo = this.getByTypeCode(type, code);
        if(paramInfo==null){
            return new ArrayList<ParamInfo>();
        }
        ParamInfo cond = new ParamInfo();
        cond.setParentId(paramInfo.getId());
        return paramInfoDao.select(cond);
    }

    @Override
    public List<ParamInfo> getTree(String type, String code) throws BusinessException {
        //需用到自定义循环 with ..
        return paramInfoDaoExt.getTree(type,code);
    }
}
