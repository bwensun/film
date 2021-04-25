package com.bowensun.film.service.component;

import com.alibaba.fastjson.JSON;
import com.bowensun.film.common.constant.BizConstant;
import com.bowensun.film.common.util.ServletUtils;
import com.bowensun.film.domain.LoginUser;
import com.bowensun.film.domain.base.Result;
import com.bowensun.film.domain.entity.LoginInfoEntity;
import com.bowensun.film.service.LoginInfoService;
import com.bowensun.film.service.mapstruct.LoginInfoConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * 登录用户退出处理
 *
 * @author 郑建雄
 * @date 2021/4/20
 */
@Component
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Resource
    private TokenService tokenService;

    @Resource
    private LoginInfoService loginInfoService;

    @Resource
    private LoginInfoConverter loginInfoConverter;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (Objects.nonNull(loginUser)) {
            Long userId = loginUser.getUser().getId();
            tokenService.delLoginUser(userId);
            //插入登录日志
            LoginInfoEntity loginInfo = loginInfoConverter.to(loginUser);
            loginInfo.setMsg("退出成功");
            loginInfo.setStatus(BizConstant.LoginStatus.OFFLINE);
            loginInfoService.save(loginInfo);
        }
        ServletUtils.renderString(response, JSON.toJSONString(Result.success("退出成功")));
    }
}
