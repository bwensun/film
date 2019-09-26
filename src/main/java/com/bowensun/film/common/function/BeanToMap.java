package com.bowensun.film.common.function;

import java.util.Map;

/**
 * @author 郑建雄
 * @program film
 * @description
 * @date 2019/9/6
 */
@FunctionalInterface
public interface BeanToMap<T> {
    /**
     * 转换javaBean对象为Map
     *
     * @param t
     * @return
     */
    Map convertToMap(T t);
}
