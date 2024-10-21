//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.thy.bbb_lbb.result;

import com.thy.bbb_lbb.domain.bo.ErrorCodeEnum;

public class GlobalException extends RuntimeException {
    protected static final long serialVersionUID = -8814203023060341795L;
    protected final ErrorInfo errorInfo;

    public GlobalException(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public GlobalException(ErrorCodeEnum code, String msg) {
        this(new ErrorInfo(code, msg));
    }

    public GlobalException(String msg) {
        this(ErrorCodeEnum.UNKNOWN, msg);
    }

    public ErrorInfo getErrorInfo() {
        return this.errorInfo;
    }
}
