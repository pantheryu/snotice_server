package com.kevin.framework.error;

/**
 * Created by spirit on 2015/10/8.
 */
public enum ApiErrorCodes {

    SUCCESS(0),
    UNKNOWN(-1),
    SYSTEM_ERROR(-2),
    /**
     * ��ʾLTSIDʧЧ
     */
    ILLEGAL_SESSION(-3),
    /**
     * WapSessionʧЧ
     */
    WAPSESSION_EXPIRED(-4),
    /**
     * ������Ч����ʹ�õ�apiV2��ȴû��ǩ��; ����ǩ������ȷ��)
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
