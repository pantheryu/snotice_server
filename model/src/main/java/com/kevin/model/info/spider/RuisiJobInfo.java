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

@TargetUrl("http://rs.xidian.edu.cn/forum.php\\?mod=viewthread&tid=\\d+\\d+\\d+\\d+\\d+\\d+&extra=page%3D1")
@HelpUrl("http://rs.xidian.edu.cn/forum.php\\?mod=forumdisplay&fid=554")
public class RuisiJobInfo extends BaseNoticeMessage implements AfterExtractor {

    @ExtractBy("//span[@id=\"thread_subject\"]/text()")
    private String myTitle;

    @ExtractBy("//div[@class=\"authi\"]//regex('\\d+-\\d+-\\d\\s+\\d+:\\d+')")
   // @ExtractBy(value = "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})",type = ExtractBy.Type.Regex)
    private String myDateTime;

    @ExtractBy("//tbody/tr[3]/td[@class=\"detailcontent\"]/text()")
    private String destination;

    @ExtractBy("//tbody/tr[4]/td[@class=\"detailcontent\"]/text()")
    private String author;

    //@ExtractBy(value = "时间:(.*?) &",type = ExtractBy.Type.Regex)
    //@ExtractBy(value = "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2})",type = ExtractBy.Type.Regex)
    @ExtractBy("//div[@class=\"authi\"]//regex('\\d+-\\d+-\\d\\s+\\d+:\\d+')")
    private String sendTime;

    //    @ComboExtract(value = { @ExtractBy(value = "h1.OSCTitle", type = ExprType.CSS),
//            @ExtractBy(value = "//title/text()", type = ExprType.XPATH) }, op = OP.OR)
//    @Inject
//    @ComboExtract(value = {@ExtractBy("//tbody/tr[6]/td[@class=\"detailcontent\"]/tidyText()"), @ExtractBy("//tbody/tr[6]/td[@class=\"detailcontent\"]/text()")}, op = ComboExtract.Op.Or)
//    @ExtractBy("//tbody/tr[6]/td[@class=\"detailcontent\"]/tidyText()")
    @ExtractBy("//td[@class=\"t_f\"]/tidyText()")
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

    //get palace
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        if (destination != null) {
            setPlace(destination);
        } else {
            setTitle("place");
        }

        this.destination = getDestination();
    }

    //get author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author!=null){
            this.author = author;
        }
    }


    //get send time
    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        if (sendTime != null) {
            String add = ":00";
            this.sendTime = sendTime + add;
            DateFormat type = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            String str = null;
            try {
                date = type.parse(this.sendTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            setSendDate(date);
        } else {
            DateFormat type = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            String str = null;
            try {
                date = type.parse("1992-10-25 07:40:00");
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

    //get the time to happen
    public String getMyDateTime() {
        return myDateTime;
    }

    public void setMyDateTime(String myDateTime) {
        if (myDateTime != null) {
            this.myDateTime = myDateTime;

            DateFormat type= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            String str = null;
            try {
                date = type.parse(myDateTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            setDate(date);
        }

    }

    private int myuserId = 100;

    public int getMyuserId() {
        return myuserId;
    }

    public void setMyuserId(int myuserId) {
        setUserId(100);
        this.myuserId = myuserId;
    }

    private int mydown = 0;

    public int getMydown() {
        return mydown;
    }

    public void setMydown (int mydown) {
        this.mydown = mydown;
        setDown(0);
    }

    private int myup = 0;

    public int  getMyup() {
        return myup;
    }

    public void setMyup(int myup) {
        this.myup = myup;
        setUp(0);
    }
    private int mycategoryId = 0;

    public int getMycategoryId() {
        return mycategoryId;
    }

    public void setMycategoryId(int mycategoryId) {
        this.mycategoryId = mycategoryId;
        setMycategoryId(2);
    }
    private int mydesId = 0;

    public int getMydesId () {
        return mydesId;
    }

    public void setMydesId (int mydesId) {
        this.mydesId = mydesId;
        setDesId(20);
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
