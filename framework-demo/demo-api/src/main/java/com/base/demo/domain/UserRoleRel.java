package com.base.demo.domain;

import javax.persistence.*;

@Table(name = "t_base_user_role_rel")
public class UserRoleRel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_base_user_role_rel.id
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_base_user_role_rel.user_id
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_base_user_role_rel.role_id
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    private String roleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_base_user_role_rel.id
     *
     * @return the value of t_base_user_role_rel.id
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_base_user_role_rel.id
     *
     * @param id the value for t_base_user_role_rel.id
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_base_user_role_rel.user_id
     *
     * @return the value of t_base_user_role_rel.user_id
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_base_user_role_rel.user_id
     *
     * @param userId the value for t_base_user_role_rel.user_id
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_base_user_role_rel.role_id
     *
     * @return the value of t_base_user_role_rel.role_id
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_base_user_role_rel.role_id
     *
     * @param roleId the value for t_base_user_role_rel.role_id
     *
     * @mbg.generated Wed Apr 18 17:21:55 CST 2018
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}