package com.bowensun.film.common.config.redis;


import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Redis操作类
 *
 * @author 郑建雄
 * @date 2019/5/15
 */
@SuppressWarnings({"rawtypes", "unchecked", "unused", "ConstantConditions", "UnusedReturnValue"})
@Component
public class RedisCache {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 存入指定值
     * 对象、string
     *
     * @param key   缓存的键值
     * @param value 缓存的值
     */
    public <T> void setCacheObject(final String key, final T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key      缓存的键值
     * @param value    缓存的值
     * @param timeout  时间
     * @param timeUnit 时间颗粒度
     */
    public <T> void setCacheObject(final String key, final T value, final Integer timeout, final TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 设置有效时间
     *
     * @param key     Redis键
     * @param timeout 超时时间
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout) {
        return expire(key, timeout, TimeUnit.SECONDS);
    }


    /**
     * 设置有效时间
     *
     * @param key     Redis键
     * @param timeout 超时时间
     * @param unit    时间单位
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout, final TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 获得缓存的基本对象。
     *
     * @param key 缓存键值
     * @return 缓存键值对应的数据
     */
    public <T> T getCacheObject(final String key) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 删除单个对象
     *
     * @param key 键
     */
    public boolean deleteObject(final String key) {
        return redisTemplate.delete(key);
    }

    /**
     * 删除集合对象
     *
     * @param collection 多个对象
     * @return 成功的数量
     */
    public long deleteObject(final Collection collection) {
        return redisTemplate.delete(collection);
    }

    /**
     * 缓存List数据
     *
     * @param key      缓存的键值
     * @param dataList 待缓存的List数据
     * @return 缓存的对象
     */
    public <T> long setCacheList(final String key, final List<T> dataList) {
        Long count = redisTemplate.opsForList().rightPushAll(key, dataList);
        return count == null ? 0 : count;
    }

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    public <T> List<T> getCacheList(final String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 缓存Set
     *
     * @param key     缓存键值
     * @param dataSet 缓存的数据
     * @return 缓存数据的对象
     */
    public <T> long setCacheSet(final String key, final Set<T> dataSet) {
        Long count = redisTemplate.opsForSet().add(key, dataSet);
        return count == null ? 0 : count;
    }

    /**
     * 获得缓存的set
     *
     * @param key 键
     * @return set集合
     */
    public <T> Set<T> getCacheSet(final String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 缓存Map
     *
     * @param key     键
     * @param dataMap map集合
     */
    public <T> void setCacheMap(final String key, final Map<String, T> dataMap) {
        if (dataMap != null) {
            redisTemplate.opsForHash().putAll(key, dataMap);
        }
    }

    /**
     * 获得缓存的Map
     *
     * @param key 键
     * @return map集合
     */
    public <T> Map<String, T> getCacheMap(final String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 往Hash中存入数据
     *
     * @param key   Redis键
     * @param hKey  Hash键
     * @param value 值
     */
    public <T> void setCacheMapValue(final String key, final String hKey, final T value) {
        redisTemplate.opsForHash().put(key, hKey, value);
    }

    /**
     * 获取Hash中的数据
     *
     * @param key  Redis键
     * @param hKey Hash键
     * @return Hash中的对象
     */
    public <T> T getCacheMapValue(final String key, final String hKey) {
        HashOperations<String, String, T> opsForHash = redisTemplate.opsForHash();
        return opsForHash.get(key, hKey);
    }

    /**
     * 获取多个Hash中的数据
     *
     * @param key   Redis键
     * @param hKeys Hash键集合
     * @return Hash对象集合
     */
    public <T> List<T> getMultiCacheMapValue(final String key, final Collection<Object> hKeys) {
        return redisTemplate.opsForHash().multiGet(key, hKeys);
    }

    /**
     * 获取多个Hash中的数据
     *
     * @param scanOptions Hash键集合
     * @param key   Redis键
     * @return Hash对象集合
     */
    public <T> Cursor getMultiCacheMapValue(final String key, final ScanOptions scanOptions) {
        Cursor scan = redisTemplate.opsForHash().scan(key, scanOptions);
        return redisTemplate.opsForHash().scan(key, scanOptions);
    }

    /**
     * 存入指定key的sortSet
     *
     * @param key   Redis键
     * @param value 对象
     * @param score 排序值
     * @return 存入结果
     */
    public boolean setSortObject(final String key, final Object value, final double score) {
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    /**
     * 存入指定key的sortSet
     *
     * @param key      Redis键
     * @param tupleSet set集合
     * @return 存入数量
     */
    public Long setSortObject(final String key, final Set<ZSetOperations.TypedTuple<Object>> tupleSet) {
        return redisTemplate.opsForZSet().add(key, tupleSet);
    }

    /**
     * 获取指定key指定value的score值
     *
     * @param key   Redis键
     * @param value 存入的值
     * @return score
     */
    public Double score(final String key, final Object value) {
        return redisTemplate.opsForZSet().score(key, value);
    }

    /**
     * 变更指定key指定value的score值
     *
     * @param key   Redis键
     * @param value 存入的值
     * @param delta 偏移量
     * @return 变更后的score
     */
    public Double incrementScore(final String key, final Object value, final double delta) {
        return redisTemplate.opsForZSet().incrementScore(key, value, delta);
    }

    /**
     * 获取指定score范围指定key的set集合
     *
     * @param key Redis键
     * @param min score最小值
     * @param max score最大值
     * @return 满足条件的set集合
     */
    public <T> Set<T> rangeByScore(final String key, final double min, final double max) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }

    /**
     * 获取指定key的score排行前几名的value的set集合
     *
     * @param key    Redis键
     * @param offset 起始值
     * @param count  总数
     * @return 满足条件的set集合
     */
    public <T> Set<T> revRange(final String key, final long offset, final long count) {
        return redisTemplate.opsForZSet().reverseRange(key, offset, count);
    }

    /**
     * 获取指定key的score排行前几名的value 和 score 的set集合
     *
     * @param key    Redis键
     * @param offset 起始值
     * @param count  总数
     * @return 满足条件的set集合
     */
    public <T> Set<T> revRangeWithScores(final String key, final long offset, final long count) {
        return redisTemplate.opsForZSet().reverseRangeWithScores(key, offset, count);
    }

    /**
     * 获取指定key的score排行前几名的set集合 带上score
     *
     * @param key    Redis键
     * @param offset 起始值
     * @param count  总数
     * @return 满足条件的set集合
     */
    public <T> Set<T> revRangeByScore(final String key, final long offset, final long count) {
        return redisTemplate.opsForZSet().reverseRangeByScore(key, 0, -1, offset, count);
    }

    /**
     * 获取指定key的score排行前几名的set集合 带上score
     *
     * @param key Redis键
     * @param min score最小值
     * @param max top
     * @return 满足条件的set集合
     */
    public <T> Set<T> revRangeByScore(final String key, final long offset, final long count, final double min, final double max) {
        return redisTemplate.opsForZSet().reverseRangeByScore(key, min, max, offset, count);

    }


    /**
     * 获得缓存的基本对象列表
     *
     * @param pattern 字符串前缀
     * @return 对象列表
     */
    public Collection<String> keys(final String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * scan获取满足条件的key
     * 不同于keys
     * scan是由limit的且安全的
     *
     * @param pattern 匹配规则
     * @param count 数量
     * @return 满足条件的key
     */
    public Set<String> scan(String pattern, long count) {
        return (Set<String>) redisTemplate.execute((RedisCallback<Set<String>>) connection -> {
            Set<String> keysTmp = new HashSet<>();
            Cursor<byte[]> cursor = connection.scan(new ScanOptions.ScanOptionsBuilder()
                    .match(pattern)
                    .count(count).build());
            while (cursor.hasNext()) {
                keysTmp.add(new String(cursor.next(), StandardCharsets.UTF_8));
            }
            return keysTmp;
        });
    }
}
