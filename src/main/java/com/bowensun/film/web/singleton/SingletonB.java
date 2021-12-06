package com.bowensun.film.web.singleton;

/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/10/26
 */
public class SingletonB {

    private static final SingletonB SINGLETONB = new SingletonB();

    private SingletonB() {
    }

    public static SingletonB getInstance(){
        return SINGLETONB;
    }
}
