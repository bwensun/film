package com.bowensun.film.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/10/27
 */
@Data
public class UserProperties {

    private String name;

    private Long age;

    private DogProperties dog;
}
