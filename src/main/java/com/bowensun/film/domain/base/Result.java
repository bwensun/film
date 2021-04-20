package com.bowensun.film.domain.base;

/**
 * 统一结果返回
 *
 * @author 郑建雄
 * @date 2021/4/20
 */
public class Result<T> {

    /**
     * 结果是否成功
     */
    public  boolean success;

    /**
     * 结果信息
     */
    public String message;

    /**
     * 返回对象
     */
    public T data;

    private Result(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static Result<?> success() {
        return new Result<>(true, "ok", null);
    }

    public static<T> Result<T> success(T data) {
        return new Result<>(true, "ok", data);
    }

    public static Result<?> error(String message) {
        return new Result<>(false, message, null);
    }

    public static<T> Result<T> error(String message, T data) {
        return new Result<>(false, message, data);
    }
}
