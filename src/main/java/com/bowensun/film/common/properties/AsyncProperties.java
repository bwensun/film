package com.bowensun.film.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 异步配置
 *
 * @author 郑建雄
 * @date 2021/7/20
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "film.async")
public class AsyncProperties {

    /**
     * 核心线程数
     */
    private int corePoolSize;

    /**
     * 最大线程数
     */
    private int maxPoolSize;

    /**
     * 队列大小
     */
    private int queueCapacity;

    /**
     * 线程最大空闲时间
     */
    private int keepAliveSeconds;

    /**
     * 线程名称前缀
     */
    private String threadNamePrefix;
}
