package com.bowensun.film.common.util;


/**
 * 字符串处理
 *
 * @author 郑建雄
 * @date 2021/12/17
 */
public class StringUtil {

    static final String SPECIAL_STR = "\\";
    private static final String SPECIAL_STR_REGEX = "∏¥§℅€℃£℉№℡‰$¢∮※？`~!@#￥%^&*（）_+<>?{}";

    private StringUtil() {
    }

    public static boolean isContainSpecStr(String str) {
        if (str.contains(SPECIAL_STR)) {
            return true;
        }
        for (char c : SPECIAL_STR_REGEX.toCharArray()) {
            if (str.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}
