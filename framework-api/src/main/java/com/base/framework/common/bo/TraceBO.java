package com.base.framework.common.bo;

import java.io.Serializable;

/**
 * TraceBO
 * @author zhouyw
 * @date 2018.05.04
 */
public class TraceBO implements Serializable {

    private static final long serialVersionUID = 1L;
    //追踪id
    private String traceId;

    //块id
    private String spanId;

    //是否上送追踪服务器
    private String spanExportable;

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

    public String getSpanExportable() {
        return spanExportable;
    }

    public void setSpanExportable(String spanExportable) {
        this.spanExportable = spanExportable;
    }
}
