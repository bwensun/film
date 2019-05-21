package com.bowensun.film.common.config.redis;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.stream.Stream;

/**
 * @author 郑建雄
 * @program film
 * @description
 * @date 2019/5/15
 */
@Component
public class RedisCache {

    @Value("${redis.expireTime}")
    private Long expireTime;

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private ValueOperations valueOperations;

    /**
     * 存入指定的key
     *
     * @param key
     * @param value
     */
    @SuppressWarnings("unchecked")
    public void set(String key, Object value){
        System.out.println(expireTime);
        valueOperations.set(key, value, expireTime);
    }

    /**
     * 获取指定的key
     *
     * @param key
     * @return
     */
    public Object get(String key){
        return valueOperations.get(key);
    }

    /**
     * 批量删除
     *
     * @param keys
     */
    @SuppressWarnings("unchecked")
    public void del(final String ...keys){
        Stream.of(keys).forEach(x -> valueOperations.getOperations().delete(x));
    }

    /**
     * 是否存在该key
     *
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public boolean isExist(String key){
        return redisTemplate.hasKey(key);
    }


}
