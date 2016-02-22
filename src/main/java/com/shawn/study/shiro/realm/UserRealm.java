package com.shawn.study.shiro.realm;

import com.shawn.study.shiro.entity.Role;
import com.shawn.study.shiro.entity.User;
import com.shawn.study.shiro.service.PermissionService;
import com.shawn.study.shiro.service.RoleService;
import com.shawn.study.shiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.security.auth.login.AccountNotFoundException;

/**
 * Created by Shawn on 2016/2/22.
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;

    /**
     * Shiro登录认证
     * 原理：1.用户提交 用户名和密码
     * 2.shiro 封装令牌
     * 3.realm 通过用户名将密码查询返回
     * 4.shiro 自动去比较查询出密码和用户输入密码是否一致
     * 5.进行登陆控制
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        System.out.println("Shiro开始登录认证...");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.findUserByUsername(token.getUsername());
        if (null == user || user.getDeleted()) {
            throw new UnknownAccountException();
        }
        if (user.getLocked()) {
            throw new LockedAccountException();
        }
        return new SimpleAuthenticationInfo(user, user.getPassword().toCharArray(), getName());
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        User user = userService.findUserByUsername(username);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleService.findStringRolesByUser(user));
        authorizationInfo.setStringPermissions(permissionService.findStringPermissionsByRoles());


        return null;
    }
}
