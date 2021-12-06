package com.bowensun.film.web.prototype;

/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/10/27
 */
public class Test {

    public static void main(String[] args) {
        final User user = new User();
        user.setAge(15L);
        user.setUsername("张三");
        PrototypeManager.putObject(User.class, user);

        final User user2 = PrototypeManager.getObject(User.class);
        System.out.println(user2.getUsername());
    }
}
