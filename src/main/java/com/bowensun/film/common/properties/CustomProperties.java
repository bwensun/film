package com.bowensun.film.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/3/24
 */
@ConfigurationProperties(prefix = "custom")
@Getter
@Setter
@Component
public class CustomProperties {

    @NestedConfigurationProperty
    private TaskProperties taskProperties;
}
