package com.base.demo.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_base_union_info")
public class UnionInfo implements Serializable {
    /**
     * 平台id
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 平台名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 域名
     */
    @Column(name = "domail_url")
    private String domailUrl;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 创建人
     */
    @Column(name = "create_user_id")
    private String createUserId;

    /**
     * 创建时间
     */
    @Column(name = "create_ts")
    private Date createTs;

    /**
     * 更新人id
     */
    @Column(name = "update_user_id")
    private String updateUserId;

    @Column(name = "update_ts")
    private Date updateTs;

    private static final long serialVersionUID = 1L;

    /**
     * 获取平台id
     *
     * @return id - 平台id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置平台id
     *
     * @param id 平台id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取平台名称
     *
     * @return name - 平台名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置平台名称
     *
     * @param name 平台名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取域名
     *
     * @return domail_url - 域名
     */
    public String getDomailUrl() {
        return domailUrl;
    }

    /**
     * 设置域名
     *
     * @param domailUrl 域名
     */
    public void setDomailUrl(String domailUrl) {
        this.domailUrl = domailUrl;
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
     * 获取创建人
     *
     * @return create_user_id - 创建人
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置创建人
     *
     * @param createUserId 创建人
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取创建时间
     *
     * @return create_ts - 创建时间
     */
    public Date getCreateTs() {
        return createTs;
    }

    /**
     * 设置创建时间
     *
     * @param createTs 创建时间
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
     * @return update_ts
     */
    public Date getUpdateTs() {
        return updateTs;
    }

    /**
     * @param updateTs
     */
    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }
}