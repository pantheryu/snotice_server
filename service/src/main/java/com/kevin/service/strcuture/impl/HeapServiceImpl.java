package com.kevin.service.strcuture.impl;

import com.kevin.model.message.BaseNoticeMessage;
import com.kevin.model.structure.NoticeMessageHeap;
import com.kevin.model.structure.NoticeMessageSingleton;
import com.kevin.service.BaseNoticeService;
import com.kevin.service.strcuture.HeapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spirit on 2016/3/24.
 */
@Service
public class HeapServiceImpl implements HeapService {

    @Autowired
    BaseNoticeService baseNoticeService;

    public NoticeMessageHeap createHeap(List<BaseNoticeMessage> baseNoticeMessages) {
        NoticeMessageHeap noticeMessageHeap = new NoticeMessageHeap();
        try{
            BaseNoticeMessage[] list = baseNoticeMessages.toArray(new BaseNoticeMessage[baseNoticeMessages.size()]);
            int ret = noticeMessageHeap.createHeap(list);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return noticeMessageHeap;
    }

    public void scheduleHeap() {
        List<BaseNoticeMessage> baseNoticeMessages = new ArrayList<BaseNoticeMessage>();
        int num = baseNoticeService.getNoticeMsgCount(10,1);
        int count = num % 20 == 0 ? num / 20 : num / 20 + 1;
        for (int i=0;i<count;i++){
            baseNoticeMessages.addAll(baseNoticeService.getNoticeMessage(1,i,10));
        }
        NoticeMessageHeap noticeMessageHeap = createHeap(baseNoticeMessages);
        NoticeMessageSingleton noticeMessageSingleton = NoticeMessageSingleton.getInstance();
        noticeMessageSingleton.setNoticeMessageHeap(noticeMessageHeap);
    }
}
