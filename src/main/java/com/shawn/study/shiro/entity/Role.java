package com.shawn.study.shiro.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Shawn on 2016/2/22.
 */
@Entity
@Table(name = "sys_role")
public class Role implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
//    @GeneratedValue(generator = "uuid")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "locked")
    private String locked;
    @Column(name = "deleted")
    private String deleted;

    @ManyToMany(
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY//,
            //targetEntity = User.class,
            //mappedBy = "roleList"
    )
    @JoinTable(
            name = "sys_user_role",
            joinColumns = {
                    @JoinColumn(
                            name = "role_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "user_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    @OrderBy(value = "id")
    private List<User> userList;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY//,
            //targetEntity = Permission.class,
            //mappedBy = "roleList"
    )
    @JoinTable(
            name = "sys_role_permission",
            joinColumns = {
                    @JoinColumn(
                            name = "role_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "permission_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    @OrderBy(value = "id")
    private List<Permission> permissionList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
