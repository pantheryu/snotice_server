package com.kevin.service.push.impl;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import com.kevin.dao.NoticeMessageDAO;
import com.kevin.dao.UserDAO;
import com.kevin.model.message.BaseNoticeMessage;
import com.kevin.service.push.SnoticePushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by spirit on 2016/4/18.
 */
@Service
public class SnoticePushServiceImpl implements SnoticePushService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private NoticeMessageDAO noticeMessageDAO;

    protected static final Logger LOG = LoggerFactory.getLogger(SnoticePushServiceImpl.class);
    private static final String masterSecret = "0e29241de191d0654727b00f";
    private static final String appKey = "621a31e786d1af19034fd879";
    public static final String ALERT = "Test from API Example - alert";
    public static final String ALERT_TITLE = "知了";


    public void test() {
        JPushClient jpushClient = new JPushClient(masterSecret, appKey, 3);

        PushPayload payload = buildPushObject_all_all_alert();

        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result" + result);

        } catch (APIConnectionException e) {
            LOG.error("Connection error, should retry later", e);

        } catch (APIRequestException e) {
            LOG.error("Should review the error, and fix the request", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }

    public void sendPush(PushPayload pushPayload){
        JPushClient jpushClient = new JPushClient(masterSecret, appKey, 3);
        try {
            PushResult result = jpushClient.sendPush(pushPayload);
            LOG.info("Got result" + result);

        } catch (APIConnectionException e) {
            LOG.error("Connection error, should retry later", e);

        } catch (APIRequestException e) {
            LOG.error("Should review the error, and fix the request", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }

    public void pushToAll(BaseNoticeMessage baseNoticeMessage) {

    }

    @Override
    public void pushToUserByAlias(List<Integer> userIdList, int msgId) {
        BaseNoticeMessage baseNoticeMessage = noticeMessageDAO.getBaseNoticeMessageById(msgId);
        List<String> aliasNameList = new ArrayList<String>();

        for (int userId:userIdList){
            aliasNameList.add(userDAO.getAliasnameById(userId));
        }
        Map<String,String> map = new HashMap<String, String>();
        map.put("msgId", Integer.toString(msgId));

        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.alias(aliasNameList))
                .setNotification(Notification.android(baseNoticeMessage.getTitle(),ALERT_TITLE, map))
                .build();

        sendPush(payload);
    }

    public void pushToUserByAlias() {

    }

    public void pushToAll() {

    }

    public static PushPayload buildPushObject_all_all_alert() {
        return PushPayload.alertAll(ALERT);
    }
}
