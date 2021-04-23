package com.bowensun.film.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * film.jwt.token自定义配置
 *
 * @author 郑建雄
 */
@Data
@ConfigurationProperties(prefix = "film.jwt.token")
@Component
public class JwtTokenProperties {

    /**
     * 前缀
     */
    private String prefix;

    /**
     * 密钥
     */
    private String secret;

    /**
     * 签发人
     */
    private String issuer;

    /**
     * 过期时间
     */
    private int expiredTime;

    /**
     * 刷新间隔时间
     */
    private int refreshInterval;

    /**
     * 主题
     */
    private String subject;

    /**
     * 受众
     */
    private String audience;
}