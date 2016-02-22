package com.shawn.study.shiro.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Shawn on 2016/2/22.
 */
@Entity
@Table(name = "sys_permission")
public class Permission implements Serializable {
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
    @Column(name = "path")
    private String path;
    @Column(name = "locked")
    private String locked;
    @Column(name = "deleted")
    private String deleted;

    @ManyToMany(
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY,
            targetEntity = Role.class
            //,
            //mappedBy = "permissionList"
    )
    @JoinTable(
            name = "sys_role_permission",
            joinColumns = {
                    @JoinColumn(
                            name = "permission_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "role_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    //@OrderBy(value = "id")
    private List<Role> roleList;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
