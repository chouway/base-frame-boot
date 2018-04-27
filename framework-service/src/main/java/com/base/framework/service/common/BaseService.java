package com.base.framework.service.common;

import com.base.framework.common.bo.ResultBO;
import com.base.framework.common.constant.ErrConstant;
import com.base.framework.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BaseService 通用的抽象服务
 * @author zhouyw
 * @date 2018.04.18
 */
public abstract class BaseService {

    protected Logger logger = LoggerFactory.getLogger(BaseService.class);

    protected final String defaultFallback = "defaultFallback";
    /**
     * 默认的降级处理
     * @return
     */
    protected ResultBO defaultFallback(){
        ResultBO resultBO = new ResultBO();
        resultBO.setCode(ErrConstant.SERVE_BUSI);
        resultBO.setCode(ErrConstant.SERVE_BUSI_MSG);
        return resultBO;
    }

}
