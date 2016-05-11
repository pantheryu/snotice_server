package com.kevin.model.info.spider;

import com.kevin.model.message.BaseNoticeMessage;
import org.apache.commons.codec.digest.DigestUtils;
//import org.springframework.beans.factory.annotation.Value;
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

//@TargetUrl("http://job.liepin.com/[\\d_]+")
//@HelpUrl("*sojob/\\?setdefault=true&curPage=\\d+")
@TargetUrl("http://job.xidian.edu.cn/html/zpxx/jobs/\\d+\\d+\\d+\\d+\\d+.html")
@HelpUrl("http://job.xidian.edu.cn/html/zpxx/jobs/list_3_1.html")
public class JobInfo extends BaseNoticeMessage implements AfterExtractor {

    @ExtractBy("//div[@class=\"arcTitle\"]/p/text()")
    private String myTitle ="";

    //@ExtractBy("//div[@class='salary']//em")
    //@ExtractBy("//tbody/tr[2]/td[@class=\"detailcontent\"]/text()")
    //@ExtractBy(value = "<div class=\"arcInfo\">发布时间:(.+?)&nbsp</td>",type = ExtractBy.Type.Regex)
    //private String myDateTime ="1992-10-25 07:40:10";

    @ExtractBy("//tbody/tr[3]/td[@class=\"detailcontent\"]/text()")
    private String destination="place";

    //@ExtractBy(value = "<td class=\"detailtitle\">(讲座地点.+?)</td>",type = ExtractBy.Type.Regex)
    @ExtractBy("//tbody/tr[4]/td[@class=\"detailcontent\"]/text()")
    private String author="";

    //@ExtractBy(value = "时间:(.*?) &",type = ExtractBy.Type.Regex)
    @ExtractBy(value = "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2})",type = ExtractBy.Type.Regex)
    private String sendTime="";

    //@ExtractBy(value = "(讲座内容.*?)</tr>", type = ExtractBy.Type.Regex)
    @ExtractBy("//div[@class=\"arcArcWrapper\"]/div[@class=\"arcContent\"]/tidyText()")
//    @Value("112313")
    private String myDetail;

    @ExtractByUrl
    private String url="";
    private String urlMd5="";

    //get userID
    private int myuserId = 1;

    public int getMyuserId() {

        return myuserId;
    }

    public void setMyuserId(int myuserId) {
        setUserId(1);
        this.myuserId = myuserId;
    }

    //get title
    public String getMyTitle() {
        return myTitle;
    }

    public void setMyTitle(String mytitle) {
        if (mytitle != null) {
            setTitle(mytitle);
            this.myTitle = mytitle;
        } else {
            setTitle("title");
            this.myTitle = "title";
        }
    }

    //get detail information
    public String getMyDetail() {
        if (myDetail == null) {
            myDetail = "detail";
            return myDetail;
        }else {
            return myDetail;
        }
    }

    public void setMyDetail(String myDetail) {
        if (myDetail != null) {
            setDetail(myDetail);
            this.myDetail = myDetail;
        } else {
            setDetail("detail");
            this.myDetail = "detail";
        }
    }

    //get send time
    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        if (sendTime!=null){
            this.sendTime = sendTime;
            DateFormat type= new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = null;
            String str = null;
            try {
                date = type.parse(this.sendTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            setSendDate(date);
        } else {
            DateFormat type= new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = null;
            String str = null;
            try {
                date = type.parse("1992-10-25 07:40");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            setSendDate(date);
        }

    }

    //get palace
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        if (destination != null) {
            destination = "destination";
            this.destination = destination;
            setPlace(destination);
        } else {
            this.destination = "destination";
            setTitle("destination");
        }
    }

    //get mycategoryID
    private int mycategoryId = 1;

    public int getMycategoryId() {
        return mycategoryId;
    }

    public void setMycategoryId(int mycategoryId) {
        this.mycategoryId = mycategoryId;
        setMycategoryId(2);
    }

    //get up
    private int myup = 1;

    public int  getMyup() {
        return myup;
    }

    public void setMyup(int myup) {
        this.myup = myup;
        setUp(1);
    }

    //get down
    private int mydown = 1;

    public int getMydown() {
        return mydown;
    }

    public void setMydown (int mydown) {
        this.mydown = mydown;
        setDown(1);
    }

    //get desID
    private int mydesId = 1;

    public int getMydesId () {
        return mydesId;
    }

    public void setMydesId (int mydesId) {
        this.mydesId = mydesId;
        setDesId(20);
    }

    //get author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author!=null){
            this.author = author;
        } else {
            setAuthor("author");
        }
    }

    //get the time to happen
    private String myDateTime = "1992-10-25 07:40:10";
    public String getMyDateTime() {
        if(myDateTime == null) {
            myDateTime = " 1992-10-25 07:40:10 ";
            return myDateTime;
        } else {
            return myDateTime;
        }
    }

    public void setMyDateTime(String myDateTime) {
        if (myDateTime != null) {
            String str = "00";
            this.myDateTime = myDateTime + str;
            DateFormat type= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            //String str = null;
            try {
                date = type.parse(this.myDateTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            setDate(date);
        } else {
            DateFormat type= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            //String str = null;
            try {
                date = type.parse("1992-10-25 07:40:00");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            setDate(date);
        }
    }

    //get url
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        this.urlMd5 = DigestUtils.md5Hex(url);
    }

    @Override
    public void afterProcess(Page page) {

//      setDetail("detail");
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
