package com.kevin.model.message;

import com.kevin.model.utils.JsonDateSerializer;
import org.apache.commons.codec.digest.DigestUtils;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by spirit on 2015/11/2.
 */
@Component
public class BaseNoticeMessage {

    private int msgId;

    private int userId;
    //
    private String userName;
    //
    private int desId;
    private Date sendDate;
    private String title;
    private String detail;
    private Date date;
    private String place;
    private int categoryId;
    //
    private String categoryName;
    private int up,down;
    private boolean voted;
    private String picPath;
    private String url;
    private String urlMd5;

    public BaseNoticeMessage() {
    }

    public BaseNoticeMessage(NoticeMessageBuilder noticeMessageBuilder){
        BaseNoticeMessage baseNoticeMessage = new BaseNoticeMessage();
        this.msgId = noticeMessageBuilder.msgId;
        this.userId = noticeMessageBuilder.userId;
        this.userName = noticeMessageBuilder.userName;
        this.desId = noticeMessageBuilder.desId;
        this.sendDate = noticeMessageBuilder.sendDate;
        this.title = noticeMessageBuilder.title;
        this.detail = noticeMessageBuilder.detail;
        this.date = noticeMessageBuilder.date;
        this.place = noticeMessageBuilder.place;
        this.categoryId = noticeMessageBuilder.categoryId;
        this.categoryName = noticeMessageBuilder.categoryName;
        this.up = noticeMessageBuilder.up;
        this.down = noticeMessageBuilder.down;
        this.voted = noticeMessageBuilder.voted;
        this.picPath = noticeMessageBuilder.picPath;
        this.url = noticeMessageBuilder.url;
        this.urlMd5 = noticeMessageBuilder.urlMd5;
    }

    public class NoticeMessageBuilder{
        int msgId = 0;
        int userId = 0;
        //
        String userName = "";
        //
        int desId = 0;
        Date sendDate = null;
        String title = "";
        String detail = "";
        Date date = null;
        String place = "";
        int categoryId = 0;
        //
        String categoryName = "";
        int up=0,down=0;
        boolean voted = false;
        String picPath = "";
        String url = "";
        String urlMd5 = "";
        public NoticeMessageBuilder() {
        }

        public BaseNoticeMessage build(){
            return new BaseNoticeMessage(this);
        }

        public NoticeMessageBuilder msgId(int value){
            this.msgId = value;
            return this;
        }

        public NoticeMessageBuilder userId(int value){
            this.userId = value;
            return this;
        }

        public NoticeMessageBuilder userName(String value){
            this.userName = value;
            return this;
        }

        public NoticeMessageBuilder sendDate(Date value){
            this.sendDate = value;
            return this;
        }

        public NoticeMessageBuilder title(String value){
            this.title = value;
            return this;
        }

        public NoticeMessageBuilder detail(String value){
            this.detail = value;
            return this;
        }

        public NoticeMessageBuilder date(Date value){
            this.date = value;
            return this;
        }

        public NoticeMessageBuilder place(String value){
            this.place = value;
            return this;
        }

        public NoticeMessageBuilder categoryId(int value){
            this.categoryId = value;
            return this;
        }

        public NoticeMessageBuilder categoryName(String value){
            this.categoryName = value;
            return this;
        }

        public NoticeMessageBuilder up(int value){
            this.up = value;
            return this;
        }

        public NoticeMessageBuilder down(int value){
            this.down = value;
            return this;
        }

        public NoticeMessageBuilder voted(boolean value){
            this.voted = value;
            return this;
        }

        public NoticeMessageBuilder picPath(String value){
            this.picPath = value;
            return this;
        }

        public NoticeMessageBuilder desId(String value){
            this.userName = value;
            return this;
        }

        public  NoticeMessageBuilder url(String value) {
            this.url = value;
            this.urlMd5 = DigestUtils.md5Hex(value);
            return this;
        }

    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public boolean isVoted() {
        return voted;
    }

    public void setIsVoted(boolean isVoted) {
        this.voted = isVoted;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getDesId() {
        return desId;
    }

    public void setDesId(int desId) {
        this.desId = desId;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void increase(){
        this.up++;
    }

    public void decrease(){
        this.down++;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        this.urlMd5 = DigestUtils.md5Hex(url);
    }
}
