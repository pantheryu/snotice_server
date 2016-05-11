package com.kevin.test;

import com.kevin.model.message.BaseNoticeMessage;

/**
 * Created by spirit on 2016/4/1.
 */
public class Field {
    public static final BaseNoticeMessage b = new BaseNoticeMessage();

    public static BaseNoticeMessage getB() {
        return b;
    }
}
