package com.thd.bi.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * com.lenovo.dqm.bi.dto.example.Result
 *
 * @author: wanglei62
 * @DATE: 2020/2/4 9:56
 **/
@Data
public class Result<T> implements Serializable {
    public static final String SUCCESS_DEFAULT_CODE = "0";
    public static final String SUCCESS_DEFAULT_MSG = "ok";
    public static final String ERROR_DEFAULT_CODE = "-1";
    public static final String ERROR_DEFAULT_MSG = "error";
    private static final long serialVersionUID = 7289310002935043203L;
    private String code;
    private String msg;
    private T result;


    public Result(String code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }
    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result success() {
        return new Result("0", "ok");
    }

    public static Result success(Object result) {
        return new Result("0", "ok", result);
    }

    public static Result success(String msg, Object result) {
        return new Result("0", msg, result);
    }

    public static Result error() {
        return new Result("-1", "error");
    }

    public static Result error(String msg) {
        return new Result("-1", msg);
    }

    public static Result error(String code, String msg) {
        return new Result(code, msg);
    }
}
