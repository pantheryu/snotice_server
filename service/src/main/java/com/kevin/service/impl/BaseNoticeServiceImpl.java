package com.kevin.service.impl;

import com.kevin.dao.NoticeMessageDAO;
import com.kevin.model.message.BaseNoticeMessage;
import com.kevin.model.message.NoticeMessageWithCount;
import com.kevin.service.BaseNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spirit on 2016/2/24.
 */
@Service
public class BaseNoticeServiceImpl implements BaseNoticeService {
    private int pageSize = 4;
    private DateFormat df;

    @Autowired
    private NoticeMessageDAO noticeMessageDAO;
    public List<BaseNoticeMessage> getNoticeMessage(int userId, int pageNum, int categoryId) {
        df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        List<BaseNoticeMessage> baseNoticeMessages = noticeMessageDAO.getNoticeMessage(userId,pageNum*pageSize,categoryId);
        return baseNoticeMessages;
    }

    public int insertNoticeMessage(BaseNoticeMessage baseNoticeMessage) {
        return noticeMessageDAO.insertNoticeMessage(baseNoticeMessage);
    }

    public int updateNoticeMessage(int praise,int msgId){
        return noticeMessageDAO.updateNoticeMessage(praise, msgId);
    }
    public int insertNoticePraise(int userId,int msgId){
        return noticeMessageDAO.insertNoticePraise(userId, msgId);
    }

    public int getNoticeMsgCount(int categoryId,int areaId) {
        return noticeMessageDAO.selectCount(categoryId, areaId);
    }

    public List<NoticeMessageWithCount> getUserSendMessage(int userId) {
        return noticeMessageDAO.getUserSendMessage(userId);
    }

    public List<BaseNoticeMessage> getUserRecvMessage(int userId) {
        List<Integer> integers = noticeMessageDAO.getUserRecvMessage(userId);
        List<BaseNoticeMessage> userRecvMsgs = new ArrayList<BaseNoticeMessage>();
        for (int i:integers){
            BaseNoticeMessage tmp = noticeMessageDAO.getBaseNoticeMessageById(i);
            userRecvMsgs.add(tmp);
        }
        return userRecvMsgs;
    }

    public int getAreaIdByMsgId(int msgId) {
        return noticeMessageDAO.getAreaIdByMsgId(msgId);
    }

}
