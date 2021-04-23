package com.bowensun.film.common.constant;


/**
 * 常量类
 *
 * @author 郑建雄
 * @date 2021/4/20
 */
@SuppressWarnings("unused")
public final class BizConstant {

    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * 登录用户ID JWT Claim name
     */
    public final static String LOGIN_USER_ID = "login_user_id";

    /**
     * Redis 登录用户ToekN前缀
     */
    public static final String LOGIN_TOKEN_KEY = "login_user:";

    /**
     * Redis验证码前缀
     */
    public static final String CAPTCHA_CODE_KEY = "CPA:";

    /**
     * 缓存过期时间 分钟
     */
    public static int CAPTCHA_EXPIRATION = 1;

    /**
     * 用户状态
     */
    public static final class UserStatus{

        /**
         * 新建状态 未验证
         */
        public static final int NEW = 0;

        /**
         * 正常状态
         */
        public static final int NORMAL =  1;

        /**
         * 冻结
         */
        public static final int FROZEN =  2;

        /**
         * 已删除
         */
        public static final int DELETED =  3;
    }

    /**
     * 验证码类型
     */
    public static final class CaptchaType{

        /**
         * 数学
         */
        public static final String MATH = "math";

        /**
         * 字符
         */
        public static final String CHAR = "char";
    }
}
