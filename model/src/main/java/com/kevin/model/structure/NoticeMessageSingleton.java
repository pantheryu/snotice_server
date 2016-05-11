package com.kevin.model.structure;

/**
 * Created by spirit on 2016/3/30.
 */
public class NoticeMessageSingleton {
    private NoticeMessageHeap noticeMessageHeap;
    private static class SingletonHolder{
        private static final NoticeMessageSingleton INSTANCE = new NoticeMessageSingleton();
    }
    private NoticeMessageSingleton(){
        this.noticeMessageHeap = null;
    };
    public static final NoticeMessageSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public NoticeMessageHeap getNoticeMessageHeap() {
        return noticeMessageHeap;
    }

    public void setNoticeMessageHeap(NoticeMessageHeap noticeMessageHeap) {
        this.noticeMessageHeap = noticeMessageHeap;
    }
}
