//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.thy.bbb_lbb.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultBody<T> {
    @JsonProperty("code")
    private int code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("result")
    private T result;

    private ResultBody(ErrorInfo errorInfo) {
        this.code = errorInfo.getCode().getCode();
        this.message = errorInfo.getMessage();
    }

    private ResultBody(ErrorInfo errorInfo, T result) {
        this.code = errorInfo.getCode().getCode();
        this.message = errorInfo.getMessage();
        this.result = result;
    }

    private ResultBody(T result) {
        this.code = ErrorInfoEnum.SUCCESS.getCode();
        this.message = ErrorInfoEnum.SUCCESS.getMessage();
        this.result = result;
    }

    private ResultBody(int code, String msg, T result) {
        this.code = code;
        this.message = msg;
        this.result = result;
    }

    public static ResultBody<String> ok() {
        return new ResultBody(ErrorInfoEnum.SUCCESS.getMessage());
    }

    public static <T> ResultBody<T> ok(T result) {
        return new ResultBody(result);
    }

    public static ResultBody<GlobalException> err(ErrorInfo errorInfo) {
        return new ResultBody(errorInfo);
    }

    public static <T> ResultBody<T> err(ErrorInfo errorInfo, T result) {
        return new ResultBody(errorInfo, result);
    }

    public static ResultBody<GlobalException> err(String msg) {
        return new ResultBody(ErrorInfoEnum.UNKNOWN.getCode(), msg, (Object)null);
    }

    public static <T> ResultBody<T> err(String msg, T result) {
        return new ResultBody(ErrorInfoEnum.UNKNOWN.getCode(), msg, result);
    }

    public static <T> ResultBody<T> resp(int code, String msg, T result) {
        return new ResultBody(code, msg, result);
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
