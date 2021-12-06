package com.bowensun.film.common.properties;

import com.bowensun.film.web.prototype.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/10/27
 */
@EnableConfigurationProperties(value = CustomProperties.class)
@Configuration
public class PropertiesTest {

    @Resource
    private CustomProperties properties;

    @Bean(name = "proUser")
    User user(){
        final User user = new User();
        user.setUsername(properties.getUser().getName());
        user.setAge(properties.getUser().getAge());
        return user;
    }
}
