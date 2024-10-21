package com.thy.bbb_lbb.result;

import com.thy.bbb_lbb.domain.bo.ErrorCodeEnum;

import java.io.Serializable;

public class ErrorInfo implements Serializable {
    protected static final long serialVersionUID = -5852203123060342326L;

    private ErrorCodeEnum code;
    private String message;

    public ErrorInfo(ErrorCodeEnum code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorCodeEnum getCode() {
        return this.code;
    }

    public void setCode(ErrorCodeEnum code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
