package com.kevin.model.message;

import com.kevin.model.info.BaseGroupInfo;

/**
 * Created by spirit on 2016/3/30.
 */
public class NoticeMessageWithCount extends BaseNoticeMessage {
    private int totalCount;
    private int readCount;
    private int noticeCount;

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getNoticeCount() {
        return noticeCount;
    }

    public void setNoticeCount(int noticeCount) {
        this.noticeCount = noticeCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
