package com.bowensun.film.service.impl;

import com.bowensun.film.common.constant.BizConstant;
import com.bowensun.film.common.constant.CaptchaTypeEnum;
import com.bowensun.film.common.constant.ExceptionEnum;
import com.bowensun.film.common.constant.RoleEnum;
import com.bowensun.film.common.exception.BizException;
import com.bowensun.film.domain.LoginUser;
import com.bowensun.film.domain.dto.CaptchaValidateDTO;
import com.bowensun.film.domain.dto.UserRegisterDTO;
import com.bowensun.film.domain.entity.UserEntity;
import com.bowensun.film.service.CaptchaService;
import com.bowensun.film.service.LoginService;
import com.bowensun.film.service.RoleService;
import com.bowensun.film.service.UserService;
import com.bowensun.film.service.component.AsyncService;
import com.bowensun.film.service.component.TokenService;
import com.bowensun.film.service.mapstruct.UserConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 登录服务实现
 *
 * @author 郑建雄
 * @date 2021/4/20
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private TokenService tokenService;

    @Resource
    private UserService userService;

    @Resource
    private CaptchaService captchaService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserConverter userConverter;

    @Resource
    private AsyncService asyncService;

    @Override
    public String login(String username, String password) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            if (e instanceof InternalAuthenticationServiceException) {
                log.info("用户：{} 认证失败", username);
                //异步记录日志
                asyncService.recordLoginInfo(username, BizConstant.LoginStatus.ONLINE, "登录成功");
            }
            throw e;
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return tokenService.createToken(loginUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(UserRegisterDTO user) {
        //验证验证码
        CaptchaValidateDTO captchaValidate = new CaptchaValidateDTO()
                .setUsername(user.getUsername())
                .setCaptchaType(CaptchaTypeEnum.register.name())
                .setExpectedCaptcha(user.getCaptcha());
        boolean result = captchaService.captchaValidate(captchaValidate);
        if (result) {
            reEncrypt(user);
            UserEntity po = userConverter.dto2Po(user);
            userService.save(po);
            //授予基础角色
            roleService.setUserRole(po.getId(), RoleEnum.user.name());
        } else {
            log.debug("【用户注册】验证码错误");
            throw BizException.of(ExceptionEnum.CAPTCHA_ERROR);
        }
    }

    private void reEncrypt(UserRegisterDTO user) {
        String encode = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encode);
    }
}
