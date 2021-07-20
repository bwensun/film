package com.bowensun.film.service.component;

import com.bowensun.film.common.util.AddressUtils;
import com.bowensun.film.common.util.IpUtils;
import com.bowensun.film.common.util.ServletUtils;
import com.bowensun.film.domain.entity.LoginInfoEntity;
import com.bowensun.film.service.LoginInfoService;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 异步服务
 * 做一个统一管理
 * 不带返回值 更加复杂的建议使用CompletableFuture
 *
 * @author 郑建雄
 * @date 2021/7/20
 */
@Component
@Slf4j
public class AsyncService {

    @Resource
    private EmailService emailService;

    @Resource
    private LoginInfoService loginInfoService;

    @Async
    public void sendEmail(String to, String captcha){
        emailService.sendRegisterCaptcha(to, captcha);
    }

    @Async
    public void recordLoginInfo(String username, int loginStatus, String message) {
        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        //IP地址
        String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        //IP位置
        String address = AddressUtils.getRealAddressByIP(ip);
        //浏览器类型
        String browser = userAgent.getBrowser().getName();
        //操作系统类型
        String os = userAgent.getOperatingSystem().getName();
        LoginInfoEntity loginInfoEntity = new LoginInfoEntity()
                .setUsername(username)
                .setStatus(loginStatus)
                .setIpAddr(ip)
                .setLoginLocation(address)
                .setBrowser(browser)
                .setOs(os)
                .setMsg(message)
                .setLoginTime(new Date());
        loginInfoService.save(loginInfoEntity);
    }
}
