package com.kevin.model.info.spider;

import com.kevin.model.message.BaseNoticeMessage;
import org.apache.commons.codec.digest.DigestUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by PantherYu on 2016/5/8.
 */
@TargetUrl("http://club.xdnice.com/forum.php\\?mod=viewthread&tid=\\d{7}&extra=page%3D1%26filter%3Dsortid%26sortid%3D252")
@HelpUrl("http://club.xdnice.com/forum-118-\\d+.html")
public class HaowangRoomInfo extends BaseNoticeMessage implements AfterExtractor {

    @ExtractBy("//span[@id=\"thread_subject\"]/text()")
    private String myTitle;

    @ExtractBy(value = "(\\d{4}-\\d{1,2}-\\d{1,2} \\d{2}:\\d{2}:\\d{2})",type = ExtractBy.Type.Regex)
    private String sendTime;

    @ExtractBy("//div[@class=\"pcb\"]/tidyText()")
    private String myDetail;

    @ExtractByUrl
    private String url="";
    private String urlMd5="";

    //get title
    public String getMyTitle() {
        return myTitle;
    }

    public void setMyTitle(String mytitle) {
        if (mytitle != null) {
            setTitle(mytitle);
        } else {
            setTitle("title");
        }
        this.myTitle = getMyTitle();
    }

    //get detail information
    public String getMyDetail() {
        return myDetail;
    }

    public void setMyDetail(String mydetail) {
        if (mydetail != null) {
            setDetail(mydetail);
        } else {
            setDetail("Detail");
        }
        this.myDetail = mydetail;

    }


    //get send time
    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        if (sendTime != null) {
//            String add = ":00";
            this.sendTime = sendTime;// + add;
            DateFormat type = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
//            String str = null;
            try {
                date = type.parse(this.sendTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            setSendDate(date);
        }
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        this.urlMd5 = DigestUtils.md5Hex(url);
    }



    @Override
    public void afterProcess(Page page) {
        //setDetail("detail");
        setPlace("place");
        setCategoryId(2);
        setUserId(1);
        setDesId(1);

        //set date to happen
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(getSendDate());
        rightNow.add(Calendar.DAY_OF_YEAR, 3);
        Date dt1 = rightNow.getTime();
        setDate(dt1);

    }
}
