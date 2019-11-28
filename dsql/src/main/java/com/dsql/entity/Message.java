package com.dsql.entity;
/**
 * @author Deh
 * @date 2019-11-26
 * 返回信息实体
 */
public class Message {
    private int code;
    private String message;

    public Message(Code code) {
        this.code = code.getCode();
        this.message = code.getMessage();
    }

    public Message(int code, String message) {
        this.code = code;
        this.message = message;
    }

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
