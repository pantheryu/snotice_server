package com.kevin.model;

/**
 * Created by spirit on 2016/3/11.
 */
public class UserReadMessage {
    private int userId;
    private int msgId;
    private int areaId;
    private boolean isVote;
    private boolean isRead;
    private boolean isNotice;
    private boolean isPush;

    public boolean isPush() {
        return isPush;
    }

    public void setIsPush(boolean isPush) {
        this.isPush = isPush;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public boolean isVote() {
        return isVote;
    }

    public void setIsVote(boolean isVote) {
        this.isVote = isVote;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public boolean isNotice() {
        return isNotice;
    }

    public void setIsNotice(boolean isNotice) {
        this.isNotice = isNotice;
    }
}
