package com.bowensun.film.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Redis配置信息
 *
 * @author 郑建雄
 * @date 2021/2/1
 */
@ConfigurationProperties(prefix = "redis")
@Getter
@Setter
public class RedisProperties {

    /**
     * 超时时间
     */
    private int expireTime;

}
