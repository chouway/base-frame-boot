package com.base.framework.common.bo;

import java.io.Serializable;

/**
 * TraceBO
 * @author zhouyw
 * @date 2018.05.04
 */
public class TraceBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String traceId;

    private String spanId;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getSpanId() {
        return spanId;
    }

    public void setSpanId(String spanId) {
        this.spanId = spanId;
    }
}
