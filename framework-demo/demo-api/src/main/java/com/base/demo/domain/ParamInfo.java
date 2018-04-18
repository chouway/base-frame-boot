package com.base.demo.domain;

import javax.persistence.*;

@Table(name = "t_base_param_info")
public class ParamInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_base_param_info.id
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_base_param_info.code
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_base_param_info.name
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_base_param_info.type
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_base_param_info.parent_id
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    private String parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_base_param_info.remark
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_base_param_info.id
     *
     * @return the value of t_base_param_info.id
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_base_param_info.id
     *
     * @param id the value for t_base_param_info.id
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_base_param_info.code
     *
     * @return the value of t_base_param_info.code
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_base_param_info.code
     *
     * @param code the value for t_base_param_info.code
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_base_param_info.name
     *
     * @return the value of t_base_param_info.name
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_base_param_info.name
     *
     * @param name the value for t_base_param_info.name
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_base_param_info.type
     *
     * @return the value of t_base_param_info.type
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_base_param_info.type
     *
     * @param type the value for t_base_param_info.type
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_base_param_info.parent_id
     *
     * @return the value of t_base_param_info.parent_id
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_base_param_info.parent_id
     *
     * @param parentId the value for t_base_param_info.parent_id
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_base_param_info.remark
     *
     * @return the value of t_base_param_info.remark
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_base_param_info.remark
     *
     * @param remark the value for t_base_param_info.remark
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}