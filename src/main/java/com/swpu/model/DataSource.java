package com.swpu.model;

/**
 * Created by BUG666 on 2016/12/5.
 */
public class DataSource<T> {
    String message;

    int code;

    T date;

    public DataSource() {
    }

    public DataSource(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
