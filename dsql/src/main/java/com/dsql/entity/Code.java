package com.dsql.entity;


/**
 * @author Deh
 * @date 2019-11-26
 * 返回信息状态码
 */
public enum Code {
    SUCCESS(200, "请求成功"),
    CHANGED(300, "已改变"),
    ERROR(500, "请求出现问题"),
    LAZY(45011, "调用太频繁，请稍候再试");
    Code(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
