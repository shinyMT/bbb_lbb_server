//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.thy.bbb_lbb.result;

import com.thy.bbb_lbb.domain.bo.ErrorCodeEnum;
import java.util.Map;

public class MultiGlobalException extends GlobalException {
    private static final long serialVersionUID = 9173426329551759349L;
    private final Map<String, String> errMap;

    public MultiGlobalException(ErrorInfo errorInfo, Map<String, String> errMap) {
        super(errorInfo);
        this.errMap = errMap;
    }

    public MultiGlobalException(ErrorCodeEnum code, String msg, Map<String, String> errMap) {
        super(code, msg);
        this.errMap = errMap;
    }

    public MultiGlobalException(String msg, Map<String, String> errMap) {
        super(msg);
        this.errMap = errMap;
    }

    public Map<String, String> getErrMap() {
        return this.errMap;
    }
}
