package com.kevin.service.strcuture;

import com.kevin.model.message.BaseNoticeMessage;
import com.kevin.model.structure.NoticeMessageHeap;

import java.util.List;

/**
 * Created by spirit on 2016/3/24.
 */
public interface HeapService {
    public NoticeMessageHeap createHeap(List<BaseNoticeMessage> baseNoticeMessages);
    public void scheduleHeap();
}
