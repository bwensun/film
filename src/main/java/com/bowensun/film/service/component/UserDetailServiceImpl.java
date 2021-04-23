package com.bowensun.film.service.component;

import com.bowensun.film.common.constant.BizConstant;
import com.bowensun.film.common.exception.BizException;
import com.bowensun.film.domain.LoginUser;
import com.bowensun.film.domain.dto.UserDTO;
import com.bowensun.film.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 默认的用户验证服务实现
 *
 * @author 郑建雄
 * @date 2021/4/20
 */
@Slf4j
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserService userService;

    @Resource
    PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = userService.getUserDtoByUsername(username);
        if (Objects.isNull(user)) {
            log.info("登录用户：{}，不存在", username);
            //TODO: 维护异常枚举
            throw BizException.of("-1", "用户不存在");
        } else if (user.getStatus() == BizConstant.UserStatus.FROZEN) {
            log.info("登录用户：{}，已冻结", username);
            throw BizException.of("-1", "用户已冻结");
        } else if (user.getStatus() == BizConstant.UserStatus.DELETED) {
            log.info("登录用户：{}，已删除", username);
            throw BizException.of("-1", "用户已删除");
        }
        return new LoginUser(user, permissionService.getResource(user));
    }
}
