package com.kevin.service.Piepline;

import com.kevin.dao.NoticeMessageDAO;
import com.kevin.model.info.spider.RuisiTradeInfo;
import com.kevin.model.message.BaseNoticeMessage;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * Created by PantherYu on 2016/5/8.
 */
@Service
public class RuisiTradePipeline implements PageModelPipeline<RuisiTradeInfo> {
    @Resource
    private NoticeMessageDAO noticeMessageDAO;

    @Override
    public void process(RuisiTradeInfo ruisiTradeInfo, Task task) {
        BaseNoticeMessage baseNoticeMessage = null;
        noticeMessageDAO.insertNoticeMessage(ruisiTradeInfo);
    }
}
