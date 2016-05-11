package com.kevin.web.controller.callboard;

import com.kevin.framework.common.ResultCode;
import com.kevin.model.message.BaseNoticeMessage;
import com.kevin.model.structure.NoticeMessageSingleton;
import com.kevin.service.BaseNoticeService;
import com.kevin.service.UserReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * Created by spirit on 2016/2/24.
 */

@Controller
public class NoticeMessageController {
    @Autowired
    private BaseNoticeService baseNoticeService;

    @Autowired
    private BaseNoticeMessage baseNoticeMessage;

    @Autowired
    private UserReadService userReadService;
    /*
    * 返回notice_message
    * */
    @RequestMapping(value = "/notice_message.json",method = RequestMethod.GET)
    public @ResponseBody ResultCode getBaseNoticeMessage(
            @RequestParam("areaId") int userId,
            @RequestParam("pageNum") int pageNum,
            @RequestParam("categoryId") int categoryId
    ){
        ResultCode<List<BaseNoticeMessage>> result = new ResultCode();
        List<BaseNoticeMessage> baseNoticeMessages = null;
        NoticeMessageSingleton noticeMessageSingleton = NoticeMessageSingleton.getInstance();

        if (noticeMessageSingleton.getNoticeMessageHeap() != null && categoryId == 10)
            baseNoticeMessages = noticeMessageSingleton.getNoticeMessageHeap().queryHeap();
        else
            baseNoticeMessages = baseNoticeService.getNoticeMessage(userId, pageNum, categoryId);

        result.setData(baseNoticeMessages);
        return result;
    }

    /*
    * 插入notice_message
    * */
    @RequestMapping(value = "/post_notice_message",method = RequestMethod.POST)
    public @ResponseBody ResultCode pushBaseNoticeMessage(
            @RequestParam("userId") int userId,
            @RequestParam("title") String title,
            @RequestParam("detail") String detail,
            @RequestParam("date") String date,
            @RequestParam("place") String place,
            @RequestParam("categoryId") int categoryId,
            @RequestParam("desId") int desId,
            @RequestParam(value="file",required=false) MultipartFile file,
            @RequestParam("send_date") String sendDate,
            HttpServletRequest request
    ){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        ResultCode result = new ResultCode();
        baseNoticeMessage.setUserId(userId);
        baseNoticeMessage.setTitle(title);
        try {
            baseNoticeMessage.setDate(sdf.parse(date));
            baseNoticeMessage.setSendDate(sdf.parse(sendDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        baseNoticeMessage.setDetail(detail);
        baseNoticeMessage.setPlace(place);
        baseNoticeMessage.setCategoryId(categoryId);
        baseNoticeMessage.setUp(0);
        baseNoticeMessage.setDown(0);
        baseNoticeMessage.setDesId(desId);
        String path = storePic(request,file);
        if (path != null)
            baseNoticeMessage.setPicPath(path);
        int msgId = 0;
        int ret = baseNoticeService.insertNoticeMessage(baseNoticeMessage);
        if (ret == 1){
            msgId = baseNoticeMessage.getMsgId();
            ret = userReadService.insert(msgId);
        }
        //插入用户对消息状态
        result.setErrCode(ret);
        return result;
    }

    private String storePic(HttpServletRequest request,MultipartFile file){
        //获得物理路径webapp所在路径
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path2 = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path2+"/";
        System.out.println(pathRoot);
        System.out.println(basePath);
        String urlPath = "";
        String path="";
        String uuid = null;
        if(!file.isEmpty()){
            //生成uuid作为文件名称
            uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=file.getContentType();
            //获得文件后缀名称
            String imageName=contentType.substring(contentType.indexOf("/")+1);
            path="/WEB-INF/img/"+uuid+".jpg";
            urlPath = "/img/"+uuid+"."+imageName;
            try {
                file.transferTo(new File(pathRoot+path));
                return "img/"+uuid+".jpg";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /*
    * 此接口用于更新用户对某一条msg的状态，包括{点赞，读，设置闹钟}
    * */
    @RequestMapping(value = "/update_notice_message",method = RequestMethod.GET)
    public @ResponseBody ResultCode updateBaseNoticeMessage(
            @RequestParam(value ="msgId") int msgId,
            @RequestParam(value ="praise",required = false) Integer praise,
            @RequestParam(value = "userId") int userId,
            @RequestParam(value = "read",required = false) Integer read,
            @RequestParam(value = "notice",required = false) Integer notice
    ){
        ResultCode<Integer> result = new ResultCode();
        int ret = -1;
        int ret2 = -1;
        if (praise != null){
            ret = baseNoticeService.updateNoticeMessage(praise, msgId);
            ret2 = userReadService.update(msgId,userId,1,0,0);
        }

        if (read != null)
            ret2 = userReadService.update(msgId,userId,0,1,0);

        if (notice != null)
            ret2 = userReadService.update(msgId,userId,0,0,1);

        result.setErrCode(ret2);
        result.setData(ret);
        return result;
    }
}
