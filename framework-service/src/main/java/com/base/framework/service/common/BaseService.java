package com.base.framework.service.common;

import com.base.framework.common.bo.ResultBO;
import com.base.framework.common.bo.TraceBO;
import com.base.framework.common.constant.ErrConstant;
import com.base.framework.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * BaseService 通用的抽象服务
 * @author zhouyw
 * @date 2018.04.18
 */
public abstract class BaseService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final String defaultFallback = "defaultFallback";
    /**
     * 默认的降级处理
     * @return
     */
    protected ResultBO defaultFallback(Throwable e){
        ResultBO resultBO = new ResultBO();
        if(e instanceof BusinessException){
            resultBO.setCode(ErrConstant.ERROR_BUSI);
            resultBO.setMessage(e.getMessage());
        }else{
            resultBO.setCode(ErrConstant.ERROR_SERVER);
            resultBO.setMessage(ErrConstant.ERROR_SERVER_MSG);
        }
        resultBO.setTraceBO(this.getTraceBO());
        return resultBO;
    }

    protected TraceBO getTraceBO(){
        TraceBO traceBO = new TraceBO();
        traceBO.setTraceId(MDC.get("traceId"));
        traceBO.setSpanId(MDC.get("spanId"));
        return traceBO;
    }

}
