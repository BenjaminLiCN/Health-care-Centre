package com.benjamin.wte.utils;

public class WebResults<T> {
    private int code;
    private T dat;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return dat;
    }

    public void setData(T dat) {
        this.dat = dat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
