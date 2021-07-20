package com.bowensun.film.common.properties;

import com.bowensun.film.domain.UserPO;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试配置
 *
 * @author 郑建雄
 * @date 2021/2/1
 */
@Configuration
@EnableConfigurationProperties({RedisProperties.class})
public class RedisConfiguration {

    private final RedisProperties properties;

    public RedisConfiguration(RedisProperties properties) {
        this.properties = properties;
    }

    @Bean("testUser")
    public UserPO user(){
        UserPO user = new UserPO();
        user.setName(String.valueOf(properties.getExpireTime()));
        return user;
    }
}
