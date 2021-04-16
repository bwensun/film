package com.bowensun.film.service;

/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/3/25
 */
public class Test2 {

    private Test2 test;

    public Test2 getInstance(){
        if (test == null){
            test = new Test2();
        }
        return test;
    }

    private Test2() {
    }
}
