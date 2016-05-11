package com.kevin.framework.error;

/**
 * Created by spirit on 2015/10/8.
 */
public enum ApiErrorCodes {

    SUCCESS(0),
    UNKNOWN(-1),
    SYSTEM_ERROR(-2),
    /**
     * 表示LTSID失效
     */
    ILLEGAL_SESSION(-3),
    /**
     * WapSession失效
     */
    WAPSESSION_EXPIRED(-4),
    /**
     * 请求无效（如使用的apiV2，却没有签名; 或者签名不正确等)
     */
    BAD_REQUEST(-5),
    ;

    private int value;

    private ApiErrorCodes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
