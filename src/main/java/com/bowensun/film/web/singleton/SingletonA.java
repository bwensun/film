package com.bowensun.film.web.singleton;

/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/10/26
 */
public class SingletonA {

    private static SingletonA singletonA;

    private SingletonA() {
    }

    public static SingletonA getInstance(){
        if (singletonA == null){
            return new SingletonA();
        }
        return singletonA;
    }
}
