package com.bowensun.film.common;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * description
 *
 * @author bowensun
 * @date 2018/12/2
 */
public class ShiroRedisCacheManager implements CacheManager {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return new ShiroRedisCache<>(name, redisTemplate);
    }
}
