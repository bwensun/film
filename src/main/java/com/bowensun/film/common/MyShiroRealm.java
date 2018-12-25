package com.bowensun.film.common;


import com.bowensun.film.domain.SysPermission;
import com.bowensun.film.domain.SysRole;
import com.bowensun.film.domain.UserInfo;
import com.bowensun.film.repository.PermissionDao;
import com.bowensun.film.repository.RoleDao;
import com.bowensun.film.repository.UserInfoDao;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import groovy.transform.builder.InitializerStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * description
 *
 * @author bowensun
 * @date 2018/11/3
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    /**
     * 权限控制
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();

        log.info("-----获取用户：" + userInfo.getUsername() + "角色及权限-----");

        String username = userInfo.getUsername();
        //获取用户角色列表并去重
        Set<String> roleSet = new HashSet<>();
        if(!Strings.isNullOrEmpty(username)){
            roleSet = roleDao.selectByUserName(username).stream().map(x -> x.getRole()).collect(Collectors.toSet());
        }
        simpleAuthorizationInfo.setRoles(roleSet);
        //遍历获取角色权限，添加到权限验证中
        Set<String> permissionSet = new HashSet<>();
        if(!Strings.isNullOrEmpty(username)){
            permissionSet = permissionDao.selectByUserName(username).stream().map(x -> x.getPermission()).collect(Collectors.toSet());
        }
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("开始进行认证");
        //前台传入
        String userName = (String)token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        UserInfo userInfo = userInfoDao.selectByUserName(userName);
        if (null == userInfo) {
            throw new AccountException("用户名不正确");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(userInfo, password,getName());
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(userInfo.getSalt()));

        return simpleAuthenticationInfo;
    }
}
