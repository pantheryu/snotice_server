package com.kevin.service.Piepline;

import com.kevin.dao.NoticeMessageDAO;
import com.kevin.model.message.BaseNoticeMessage;
import com.kevin.model.info.spider.LectureInfo;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * Created by Panther on 2016/3/10.
 */
@Service
public class LecturePipeline implements PageModelPipeline<LectureInfo> {

    @Resource
    private NoticeMessageDAO noticeMessageDAO;

    @Override
    public void process(LectureInfo lectureInfo, Task task) {
        BaseNoticeMessage baseNoticeMessage = null;
        noticeMessageDAO.insertNoticeMessage(lectureInfo);
    }
}
