package com.newthread.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Author:huangpingcaigege
 * Date:2016/7/30
 * Mail:11867939@qq.com
 */
@Entity
@Table(name = "role", schema = "shiro")
public class Role {

    private int roleId;
    private String roleName;
    private Serializable createdTime;
    private Timestamp updateTime;
    private Set<User> users = new HashSet<>();
    private Set<Permission> permissions = new HashSet<>();

    @Id
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Column(name = "role_name", nullable = true, length = 64)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Column(name = "created_time", nullable = true)
    public Serializable getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Serializable createdTime) {
        this.createdTime = createdTime;
    }

    @Column(name = "update_time", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @OneToMany(fetch = FetchType.LAZY,targetEntity = Permission.class)
    @JoinTable(name = "role_permission",joinColumns = @JoinColumn(name = "role_id"),inverseJoinColumns = @JoinColumn(name = "permission_id"))
    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
