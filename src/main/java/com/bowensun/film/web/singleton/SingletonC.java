package com.bowensun.film.web.singleton;

/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/10/26
 */
public class SingletonC {

    private static volatile SingletonC singletonC;

    private SingletonC() {
    }

    public static SingletonC getInstance(){
        if (singletonC == null){
            synchronized (SingletonC.class){
                if (singletonC == null){
                    return new SingletonC();
                }
            }
        }
        return singletonC;
    }
}
