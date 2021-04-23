package com.bowensun.film.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * 自定义属性配置
 *
 * @author 郑建雄
 * @date 2021/3/24
 */
@ConfigurationProperties(prefix = "film")
@Data
@Component
public class FilmProperties {

    @NestedConfigurationProperty
    private CaptchaProperties captcha;

    @Data
    public static class CaptchaProperties {

        /**
         * 类型
         */
        private String type;
    }

    @Data
    public static class ConfigProperties {

        /**
         * 类型
         */
        public static boolean isAddressEnabled;
    }
}
