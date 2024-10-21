package com.thy.bbb_lbb.domain.bo;

public class ErrCode {
    // --------------- 正常 ---------------
    public static final int OK = 200;

    // --------------- 警告 ---------------
    // 不允许执行后续处理
    public static final int WARN_DENY = 101;

    // --------------- 错误 -----------------
    // 服务器异常
    public static final int ERROR_SERVER = -500;
    // 登录异常
    public static final int ERROR_LOGIN = -101;
    // SQL执行异常
    public static final int ERROR_SQL = -102;
    // 表已经存在
    public static final int ERROR_TABLE_EXIST = -103;
    // 数据已经存在
    public static final int ERROR_DATA_EXIST = -104;
    // 未知错误
    public static final int UNKNOWN = -1;
}
