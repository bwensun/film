package com.bowensun.film.service.component;

import cn.hutool.core.util.StrUtil;
import com.bowensun.film.common.config.redis.RedisCache;
import com.bowensun.film.common.constant.BizConstant;
import com.bowensun.film.common.properties.JwtTokenProperties;
import com.bowensun.film.common.util.AddressUtils;
import com.bowensun.film.common.util.IpUtils;
import com.bowensun.film.common.util.JwtUtil;
import com.bowensun.film.common.util.ServletUtils;
import com.bowensun.film.domain.LoginUser;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * Token基本服务封装
 *
 * @author 郑建雄
 * @date 2021/4/20
 */
@Component
public class TokenService {

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    @Resource
    private RedisCache redisCache;

    @Resource
    private JwtTokenProperties jwtTokenProperties;

    public String createToken(LoginUser loginUser) {
        //设置用户终端相关的信息，包括 IP、城市、浏览器、操作系统
        setUserAgent(loginUser);

        //记录缓存
        cacheToken(loginUser);

        // <4> 生成 JWT 的 Token
        return JwtUtil.createToken(loginUser.getUser().getId());
    }

    public void setUserAgent(LoginUser loginUser) {
        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        loginUser.setIpAddr(ip);
        loginUser.setLoginLocation(AddressUtils.getRealAddressByIP(ip));
        loginUser.setBrowser(userAgent.getBrowser().getName());
        loginUser.setOs(userAgent.getOperatingSystem().getName());
    }

    /**
     * 验证令牌有效期，自动刷新缓存
     *
     * @param loginUser 登录用户实体
     */
    public void verifyToken(LoginUser loginUser) {
        long expireTime = loginUser.getExpireTime();
        long currentTime = System.currentTimeMillis();
        // 相差不足 20 分钟，自动刷新缓存
        if (expireTime - currentTime <=  jwtTokenProperties.getRefreshInterval() * MILLIS_MINUTE) {
            cacheToken(loginUser);
        }
    }

    /**
     * 获取当前登录用户
     *
     * @param request 当前请求对象
     * @return 登录用户
     */
    public LoginUser getLoginUser(HttpServletRequest request){
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        String prefix = jwtTokenProperties.getPrefix();
        if (StrUtil.isNotEmpty(header) && header.startsWith(prefix)){
            String jwtToken = StrUtil.removePrefix(header, prefix + " ");
            Long userId = JwtUtil.parseToken(jwtToken);
            return redisCache.getCacheObject(BizConstant.LOGIN_TOKEN_KEY + userId);

        }
        return null;
    }

    /**
     * 删除Redis中缓存的登录信息
     *
     * @param userId 用户主键
     */
    public void delLoginUser(Long userId) {
        String tokenKey = getTokenKey(userId);
        redisCache.deleteObject(tokenKey);
    }

    private void cacheToken(LoginUser loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + jwtTokenProperties.getExpiredTime() * MILLIS_MINUTE);
        // 根据 uuid 将 loginUser 缓存
        String userKey = getTokenKey(loginUser.getUser().getId());
        redisCache.setCacheObject(userKey, loginUser, jwtTokenProperties.getExpiredTime(), TimeUnit.MINUTES);
    }

    private String getTokenKey(Long userId) {
        return BizConstant.LOGIN_TOKEN_KEY + userId;
    }
}
