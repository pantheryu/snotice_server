package com.kevin.web.controller.test;

import com.kevin.framework.common.ResultCode;
import com.kevin.model.message.BaseNoticeMessage;
import com.kevin.model.LivePicInfo;

import com.kevin.model.utils.PathUtils;
import com.kevin.service.impl.BaseNoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spirit on 2015/9/30.
 */
@Controller
@RequestMapping("/")
public class TestController {
    @Autowired
    private BaseNoticeServiceImpl baseNoticeService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring3 MVC");
        SimpleDateFormat dateFormat = new SimpleDateFormat("asdasd");
        model.addAttribute("date", dateFormat.format(new java.util.Date()));
        return "jsp/success.jsp";
    }
    @RequestMapping(value = "/get.json",method = RequestMethod.GET)
    public @ResponseBody
    ResultCode returnValue(HttpServletResponse response){
        ResultCode<List<BaseNoticeMessage>> result = new ResultCode();
//
//        List<BaseNoticeMessage> list = new ArrayList<BaseNoticeMessage>();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//
//        BaseNoticeMessage callboardMessage1 = new BaseNoticeMessage();
//        callboardMessage1.setCategoryId("study");
//        callboardMessage1.setDate("2015/10/23");
//        callboardMessage1.setDetail("content1");
//        callboardMessage1.setTitle("title1");
//        callboardMessage1.setPlace("place1");
//        Calendar calendar1 = Calendar.getInstance();
//        calendar1.set(2015, 11, 2, 13, 59);
//        callboardMessage1.setDate(sdf.format(calendar1.getTime()));
//        callboardMessage1.setUp(10);
//        callboardMessage1.setDown(13);
//        list.add(callboardMessage1);
//
//        BaseNoticeMessage callboardMessage2 = new BaseNoticeMessage();
//        callboardMessage2.setCategoryId("生活");
//        callboardMessage2.setDate("2015/10/22");
//        callboardMessage2.setDetail("测试数据2内容");
//        callboardMessage2.setTitle("测试数据2标题");
//        callboardMessage2.setPlace("测试数据2地点");
//        Calendar calendar2 = Calendar.getInstance();
//        calendar2.set(2002, 2, 2, 14, 58);
//        callboardMessage2.setDate(sdf.format(calendar2.getTime()));
//        callboardMessage2.setUp(132);
//        callboardMessage2.setDown(41);
//        list.add(callboardMessage2);
//
//
//        BaseNoticeMessage callboardMessage3 = new BaseNoticeMessage();
//        callboardMessage3.setCategoryId("体育");
//        callboardMessage3.setDate("2015/10/21");
//        callboardMessage3.setDetail("测试数据3内容");
//        callboardMessage3.setTitle("测试数据3标题");
//        callboardMessage3.setPlace("测试数据3地点");
//        Calendar calendar3 = Calendar.getInstance();
//        calendar3.set(2003, 3, 3, 15, 57);
//        callboardMessage3.setDate(sdf.format(calendar3.getTime()));
//        callboardMessage3.setUp(21);
//        callboardMessage3.setDown(12);
//        list.add(callboardMessage3);
//
//        list.add(callboardMessage2);
//        list.add(callboardMessage2);
//        list.add(callboardMessage2);
//        list.add(callboardMessage2);
//        list.add(callboardMessage2);
//        list.add(callboardMessage2);
//        list.add(callboardMessage2);
//        list.add(callboardMessage2);
//        list.add(callboardMessage2);
//        list.add(callboardMessage2);
//        list.add(callboardMessage2);
//        list.add(callboardMessage2);
//        list.add(callboardMessage2);
//        list.add(callboardMessage2);
//        list.add(callboardMessage2);
//
//
//        result.setData(list);
        return result;
    }

    @RequestMapping(value = "live_pic.json",method = RequestMethod.GET)
    public @ResponseBody ResultCode returnPic(HttpServletResponse response){
        ResultCode<List<LivePicInfo>> result = new ResultCode();
        List<LivePicInfo> list = new ArrayList<LivePicInfo>();
        LivePicInfo livePicInfo1 = new LivePicInfo();
        livePicInfo1.setPicStoreUrl(PathUtils.SERVER_PATH + "img/snotice.jpg");
        livePicInfo1.setPicInfoUrl(PathUtils.SERVER_PATH);
        list.add(livePicInfo1);

        LivePicInfo livePicInfo2 = new LivePicInfo();
        livePicInfo2.setPicStoreUrl(PathUtils.SERVER_PATH+"img/xidian.jpg");
        livePicInfo2.setPicInfoUrl(PathUtils.SERVER_PATH);
        list.add(livePicInfo2);

        result.setData(list);

        return result;
    }

}
