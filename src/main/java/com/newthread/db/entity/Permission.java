package com.newthread.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Author:huangpingcaigege
 * Date:2016/7/30
 * Mail:11867939@qq.com
 */
@Entity
@Table(name = "permission", schema = "shiro")
public class Permission {
    private int permissionId;
    private String permissionName;
    private Serializable createdTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "permission_id", nullable = false)
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Basic
    @Column(name = "permission_name", nullable = true, length = 64)
    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Basic
    @Column(name = "created_time", nullable = true)
    public Serializable getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Serializable createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return permissionId == that.permissionId &&
                Objects.equals(permissionName, that.permissionName) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionId, permissionName, createdTime, updateTime);
    }
}
