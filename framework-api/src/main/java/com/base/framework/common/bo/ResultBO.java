package com.base.framework.common.bo;

import java.io.Serializable;


/**
 * 响应结果
 * 使用场景可以是 程序代码调用、响应给页面 的作用
 * 包括了 是否成功、返回消息字符、信息对象、响应结果码
 *
 */
public class ResultBO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private T info;

    private String message;

    private boolean success;

    private String code;

    public ResultBO() {
    }

    /**
     * @param message 消息字符
     * @param success 是否成功
     */
    public ResultBO(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    /**
     * @param info 消息字符(success默认true)
     */
    public ResultBO(T info) {
        this.info = info;
    }

    /**
     * @param message 消息字符
     */
    public ResultBO(String message) {
        this.message = message;
    }

    /**
     * 消息字符
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * 消息字符
     *
     * @param message
     * @return
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * 是否成功
     *
     * @param success
     * @return
     */
    public ResultBO setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    /**
     * 信息对象（xml、object、jsonObject、List 等）
     *
     * @return
     */
    public T getInfo() {
        return info;
    }

    /**
     * 信息对象（xml、object、jsonObject、List 等）
     *
     * @param info
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * 响应结果码
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * 响应结果码
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }
}
