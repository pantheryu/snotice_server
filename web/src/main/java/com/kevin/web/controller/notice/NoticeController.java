package com.kevin.web.controller.notice;

import com.kevin.framework.common.ResultCode;
import com.kevin.model.message.BaseNoticeMessage;
import com.kevin.model.message.NoticeMessageWithCount;
import com.kevin.service.BaseNoticeService;
import com.kevin.service.UserReadService;
import com.kevin.service.push.SnoticePushService;
import com.kevin.service.schedule.ScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by spirit on 2016/3/30.
 */
@Controller
public class NoticeController {

    @Autowired
    BaseNoticeService baseNoticeService;
    @Autowired
    UserReadService userReadService;
    @Autowired
    private SnoticePushService snoticePushService;

    /*
    * 此接口用于获得用户的发送消息
    * */
    @RequestMapping(value = "/send_notice_msg.json",method = RequestMethod.GET)
    public @ResponseBody
    ResultCode getUserSendMessage(@RequestParam(value = "userId") int userId){
        ResultCode<List<NoticeMessageWithCount>> result = new ResultCode();
        List<NoticeMessageWithCount> noticeMessageWithCounts = baseNoticeService.getUserSendMessage(userId);
        result.setData(noticeMessageWithCounts);
        return result;
    }

    /*
    * 此接口用于获得用户的接收消息
    * */
    @RequestMapping(value = "/recv_notice_msg.json",method = RequestMethod.GET)
    public @ResponseBody
    ResultCode getUserRecvMessage(@RequestParam(value = "userId") int userId){
        ResultCode<List<BaseNoticeMessage>> result = new ResultCode();
        List<BaseNoticeMessage> baseNoticeMessages = baseNoticeService.getUserRecvMessage(userId);
        result.setData(baseNoticeMessages);
        return result;
    }

    /*
    * 此接口用于发送推送消息
    * */
    @RequestMapping(value = "/push_message.json",method = RequestMethod.GET)
    public @ResponseBody
    void pushMessages(
            @RequestParam(value = "userId") final int userId,
            @RequestParam(value = "msgId") int msgId){
        /*
        * 接下来在根据msgId得到aliasId
        * 然后发送push
        * */
        int areaId = baseNoticeService.getAreaIdByMsgId(msgId);
        List<Integer> userList = userReadService.getUserUnReadListByAreaId(areaId,msgId);
        snoticePushService.pushToUserByAlias(userList,msgId);
    }


}
