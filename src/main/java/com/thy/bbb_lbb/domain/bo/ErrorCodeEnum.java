package com.thy.bbb_lbb.domain.bo;

/**
 * @author c4x
 * date 2022-9-22
 */
public enum ErrorCodeEnum implements ICodeNameEnum {
    // 成功
    SUCCESS(0,"成功"),
    // 未知错误
    UNKNOWN(-1,"服务内部错误"),
    WARNING(1, "警告"),

    /**
     * ============APP相关问题==================
     */
    // APP版本过旧
    APP_VERSION_LOW(-200,"APP版本过旧"),
    // APP被篡改
    APP_TAMPERD(-201,"APP被篡改"),
    // 设备不安全
    APP_RISK_ENV(-202,"设备不安全"),
    // 网络环境不安全
    APP_RISK_NET(-203,"网络环境不安全"),

    /**
     * ============登录相关问题==================
     */
    // (警告)普通登录警告
    LOGIN_COMMON_WARN(300,"普通登录警告"),
    // (警告)需要设置密保问题
    LOGIN_QUESTION_REQUIRED(301,"需要设置密保问题"),
    // (警告)需要重设密码
    LOGIN_RESET_PW_REQUIRED(302,"需要重设密码"),
    // 账号密码错误
    LOGIN_PW_ERR(-303,"账号密码错误"),
    // 账户停用
    LOGIN_ACCOUNT_DISABLED(-304,"账户停用"),
    // refreshToken失效
    REFRESH_TOKEN_EXPIRED(-305,"refreshToken失效"),
    // 登录尝试过多锁定
    LOGIN_TOO_MUCH_TRY_LOCK(-306,"登录尝试过多锁定"),
    // 时间戳不合法
    LOGIN_TIMESTAMP_INVALID(-308,"时间戳不合法"),
    // 时间戳误差过大
    LOGIN_TIMESTAMP_VERIFY_FAILED(-309,"时间戳误差过大"),
    // (警告)企业微信id未设置为工号
    INIT_WXW_USER_ID(310,"企业微信id未设置为工号"),

    /**
     * ============访问权限相关问题==================
     */
    // 没有权限
    NO_PERMISSION(-400,"没有权限"),
    // accessToken无效
    TOKEN_INVALID(-401,"accessToken无效"),

    /**
     * ============功能模块相关问题==================
     */
    // 功能维护中
    FUNC_MAINTAINED(-500,"功能维护中"),
    // 功能停用
    FUNC_DEPRECATED(-501,"功能停用"),

    /**
     * ============调用相关问题==================
     */
    // 头部缺少account参数
    LEAK_PARAM_ACCOUNT(-601,"头部缺少account参数"),
    // 头部缺少accessToken参数
    LEAK_PARAM_ACCESS_TOKEN(-602,"头部缺少accessToken参数"),

    /**
     * ============SQL相关问题==================
     * */
    ERROR_TABLE_EXIST(-701, "表已经存在"),
    ERROR_SQL(-702, "建表异常"),

    /**
     * ============业务相关问题==================
     * */
    ERROR_MATERIAL(-801, "物料异常");

    // 枚举int值
    private final int code;
    // 值名称
    private final String name;

    ErrorCodeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 通过code获取枚举
     *
     * @param code 枚举int值
     * @return 枚举，如果code不存在则返回UNKNOWN
     * @author c4x
     * date 2022/3/29 12:05
     */
    public static ErrorCodeEnum getByCode(int code) {
        for (var enu : ErrorCodeEnum.values()) {
            if (enu.code == code) {
                return enu;
            }
        }
        return ErrorCodeEnum.UNKNOWN;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ICodeNameEnum getByCode(String code) {
        try {
            return ErrorCodeEnum.getByCode(Integer.parseInt(code));
        } catch (NumberFormatException ignored) {
            return ErrorCodeEnum.UNKNOWN;
        }
    }
}
