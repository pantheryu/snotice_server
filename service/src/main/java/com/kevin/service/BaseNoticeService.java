package com.kevin.service;

import com.kevin.model.message.BaseNoticeMessage;
import com.kevin.model.message.NoticeMessageWithCount;

import java.util.List;

/**
 * Created by spirit on 2016/2/24.
 */
public interface BaseNoticeService {
    public List<BaseNoticeMessage> getNoticeMessage(int areaId,int pageNum,int categoryId);
    public int insertNoticeMessage(BaseNoticeMessage baseNoticeMessage);
    public int updateNoticeMessage(int praise,int msgId);
    public int insertNoticePraise(int userId,int msgId);
    public int getNoticeMsgCount(int categoryId,int areaId);
    public List<NoticeMessageWithCount> getUserSendMessage(int userId);
    public List<BaseNoticeMessage> getUserRecvMessage(int userId);
    public int getAreaIdByMsgId(int msgId);
}
