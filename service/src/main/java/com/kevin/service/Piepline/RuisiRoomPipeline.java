package com.kevin.service.Piepline;

import com.kevin.dao.NoticeMessageDAO;
import com.kevin.model.info.spider.RuisiRoomInfo;
import com.kevin.model.message.BaseNoticeMessage;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * Created by PantherYu on 2016/5/8.
 */
@Service
public class RuisiRoomPipeline implements PageModelPipeline<RuisiRoomInfo>{
    @Resource
    private NoticeMessageDAO noticeMessageDAO;

    @Override
    public void process(RuisiRoomInfo ruisiRoomInfo, Task task) {
        BaseNoticeMessage baseNoticeMessage = null;
        noticeMessageDAO.insertNoticeMessage(ruisiRoomInfo);
    }
}
