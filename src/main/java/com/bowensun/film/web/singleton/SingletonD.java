package com.bowensun.film.web.singleton;

/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/10/26
 */
public class SingletonD {

    private SingletonD() {
    }

    private static class SingletonDHolder{
        private static final SingletonD singletonD = new SingletonD();
    }

    public static SingletonD getInstance(){
        return SingletonDHolder.singletonD;
    }
}
