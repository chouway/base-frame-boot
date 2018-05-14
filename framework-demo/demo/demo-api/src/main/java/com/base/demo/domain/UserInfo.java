package com.base.demo.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_base_user_info")
public class UserInfo implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     *  
     */
    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    /**
     * 手机号
     */
    @Column(name = "mobile_no")
    private String mobileNo;

    /**
     *  密码盐
     */
    @Column(name = "salt")
    private String salt;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 平台id
     */
    @Column(name = "union_id")
    private String unionId;

    /**
     * 认证状态： 未认证 0  ； 认证中 1 ； 已认证 2；
     */
    @Column(name = "authe_status")
    private String autheStatus;

    /**
     * 是否有效
     */
    @Column(name = "is_valid")
    private String isValid;

    /**
     * 创建人id
     */
    @Column(name = "create_user_id")
    private String createUserId;

    @Column(name = "create_ts")
    private Date createTs;

    /**
     * 更新人id
     */
    @Column(name = "update_user_id")
    private String updateUserId;

    /**
     *  更新时间
     */
    @Column(name = "update_ts")
    private Date updateTs;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 
     *
     * @return name -  
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 
     *
     * @param name  
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机号
     *
     * @return mobile_no - 手机号
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * 设置手机号
     *
     * @param mobileNo 手机号
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * 获取 密码盐
     *
     * @return salt -  密码盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置 密码盐
     *
     * @param salt  密码盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取平台id
     *
     * @return union_id - 平台id
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * 设置平台id
     *
     * @param unionId 平台id
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /**
     * 获取认证状态： 未认证 0  ； 认证中 1 ； 已认证 2；
     *
     * @return authe_status - 认证状态： 未认证 0  ； 认证中 1 ； 已认证 2；
     */
    public String getAutheStatus() {
        return autheStatus;
    }

    /**
     * 设置认证状态： 未认证 0  ； 认证中 1 ； 已认证 2；
     *
     * @param autheStatus 认证状态： 未认证 0  ； 认证中 1 ； 已认证 2；
     */
    public void setAutheStatus(String autheStatus) {
        this.autheStatus = autheStatus;
    }

    /**
     * 获取是否有效
     *
     * @return is_valid - 是否有效
     */
    public String getIsValid() {
        return isValid;
    }

    /**
     * 设置是否有效
     *
     * @param isValid 是否有效
     */
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    /**
     * 获取创建人id
     *
     * @return create_user_id - 创建人id
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置创建人id
     *
     * @param createUserId 创建人id
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * @return create_ts
     */
    public Date getCreateTs() {
        return createTs;
    }

    /**
     * @param createTs
     */
    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    /**
     * 获取更新人id
     *
     * @return update_user_id - 更新人id
     */
    public String getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 设置更新人id
     *
     * @param updateUserId 更新人id
     */
    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 获取 更新时间
     *
     * @return update_ts -  更新时间
     */
    public Date getUpdateTs() {
        return updateTs;
    }

    /**
     * 设置 更新时间
     *
     * @param updateTs  更新时间
     */
    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }
}