package com.thy.bbb_lbb.result;

import com.thy.bbb_lbb.domain.bo.ErrorCodeEnum;

public enum ErrorInfoEnum {
    SUCCESS(ErrorCodeEnum.SUCCESS.getCode(), "success"), UNKNOWN(ErrorCodeEnum.UNKNOWN.getCode(), "unknown exception");

    private int code;

    private String message;

    ErrorInfoEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
