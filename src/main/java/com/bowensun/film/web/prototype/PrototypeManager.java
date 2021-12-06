package com.bowensun.film.web.prototype;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 *
 *
 * @author 郑建雄
 * @date 2021/10/26
 */
@Slf4j
public class PrototypeManager {

    private final static HashMap<Class<?>, Object> PROTOTYPE_MAP = new HashMap<>(16);

    public static <T> void putObject(Class<T> clazz, AbstractPrototype value){
        PROTOTYPE_MAP.put(clazz, value);
    }

    public static <T> T getObject(Class<T> clazz) {
        final Object prototype = PROTOTYPE_MAP.get(clazz);
        if (prototype != null){
            return clazz.cast(prototype);
        }
        return null;
    }
}
