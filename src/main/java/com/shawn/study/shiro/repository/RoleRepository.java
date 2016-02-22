package com.shawn.study.shiro.repository;

import com.shawn.study.shiro.entity.Role;
import com.shawn.study.shiro.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Shawn on 2016/2/22.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

    @Query(value = "from Role r inner join r.userList u where u in ?1")
    public List<Role> findByUserList(List<User> userList);
}
