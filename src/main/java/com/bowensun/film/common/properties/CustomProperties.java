package com.bowensun.film.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/10/27
 */
@Data
@ConfigurationProperties(prefix = CustomProperties.PREFIX)
public class CustomProperties {

    public final static String PREFIX = "custom";

    private boolean enabled;

    @NestedConfigurationProperty
    private UserProperties user;

    @NestedConfigurationProperty
    private QnyProperties qiniuyun;
}
