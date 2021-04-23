package com.bowensun.film.service.component;

import cn.hutool.core.util.StrUtil;
import com.bowensun.film.common.util.ServletUtils;
import com.bowensun.film.domain.LoginUser;
import com.bowensun.film.domain.dto.UserDTO;
import com.bowensun.film.domain.entity.UserEntity;
import com.bowensun.film.service.ResourceService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 权限服务类
 * 对于常用的权限服务调用做了封装
 *
 * @author 郑建雄
 * @date 2021/4/20
 */
@Component("ss")
public class PermissionService {

    @Resource
    private ResourceService resourceService;

    @Resource
    private TokenService tokenService;

    private static final String ALL_PERMISSION = "*:*:*";

    public Set<String> getResource(UserDTO user) {
        HashSet<String> permissions = new HashSet<>();
        if (user.isAdmin()) {
            permissions.add("*:*:*");
        } else {
            permissions = resourceService.getPermsSet(user.getId());
        }
        return permissions;
    }

    /**
     * 验证用户是否具备某权限
     *
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    public boolean hasPermi(String permission) {
        if (StrUtil.isEmpty(permission)) {
            return false;
        }
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        if (Objects.isNull(loginUser) || CollectionUtils.isEmpty(loginUser.getPermissions())) {
            return false;
        }
        return hasPermissions(loginUser.getPermissions(), permission);
    }

    /**
     * 判断permissions是否包含permission
     */
    private boolean hasPermissions(Set<String> permissions, String permission) {
        return permissions.contains(permission) || permissions.contains(ALL_PERMISSION);
    }
}
