package com.base.demo.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_base_role_info")
public class RoleInfo {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 角色名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 角色类型：应用 0
     */
    @Column(name = "type")
    private String type;

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
     * 获取角色名称
     *
     * @return name - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取角色类型：应用 0
     *
     * @return type - 角色类型：应用 0
     */
    public String getType() {
        return type;
    }

    /**
     * 设置角色类型：应用 0
     *
     * @param type 角色类型：应用 0
     */
    public void setType(String type) {
        this.type = type;
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