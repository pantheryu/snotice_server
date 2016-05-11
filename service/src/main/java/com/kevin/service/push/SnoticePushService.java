package com.kevin.service.push;

import com.kevin.model.message.BaseNoticeMessage;

import java.util.List;

/**
 * Created by spirit on 2016/4/18.
 */
public interface SnoticePushService {
    /*
    * 测试
    * */
    public void test();

    /*
    * 发送给所有人
    * */
    public void pushToAll(BaseNoticeMessage baseNoticeMessage);

    /*
    * 发送给指定用户
    * */
    public void pushToUserByAlias(List<Integer> userIdList,int msgId);
}
