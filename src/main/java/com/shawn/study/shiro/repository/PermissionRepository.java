package com.shawn.study.shiro.repository;

import com.shawn.study.shiro.entity.Permission;
import com.shawn.study.shiro.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Shawn on 2016/2/22.
 */
public interface PermissionRepository extends CrudRepository<Permission, Long> {
    @Query(value = "from Permission p INNER JOIN p.roleList r where r in ?1")
    public List<Permission> findByRoleList(List<Role> roleList);
}
