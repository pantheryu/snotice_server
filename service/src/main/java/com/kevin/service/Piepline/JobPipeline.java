package com.kevin.service.Piepline;

import com.kevin.dao.NoticeMessageDAO;
import com.kevin.model.info.spider.JobInfo;
import com.kevin.model.message.BaseNoticeMessage;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * Created by PantherYu on 2016/4/20.
 */
@Service
public class JobPipeline implements PageModelPipeline<JobInfo>{

    @Resource
    private NoticeMessageDAO noticeMessageDAO;

    @Override
    public void process(JobInfo jobInfo, Task task) {
        BaseNoticeMessage baseNoticeMessage = null;
        noticeMessageDAO.insertNoticeMessage(jobInfo);
    }
}
