package com.kevin.service.Piepline;

import com.kevin.dao.NoticeMessageDAO;
import com.kevin.model.info.spider.RuisiJobInfo;
import com.kevin.model.message.BaseNoticeMessage;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * Created by PantherYu on 2016/5/8.
 */
@Service
public class RuisiJobPipeline implements PageModelPipeline<RuisiJobInfo>{

        @Resource
        private NoticeMessageDAO noticeMessageDAO;

        @Override
        public void process(RuisiJobInfo ruisiJobInfo, Task task) {
            BaseNoticeMessage baseNoticeMessage = null;
            noticeMessageDAO.insertNoticeMessage(ruisiJobInfo);
        }
}


