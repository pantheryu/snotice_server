package com.kevin.service.schedule;

import com.kevin.model.structure.NoticeMessageHeap;
import com.kevin.model.structure.NoticeMessageSingleton;
import com.kevin.service.BaseNoticeService;
import com.kevin.service.SpiderService;
import com.kevin.service.strcuture.HeapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * Created by spirit on 2016/3/8.
 */
@Component
public class ScheduleTask {

    @Autowired
    private HeapService heapService;

    @Autowired
    private SpiderService spiderService;

//    @Scheduled(cron="0 0 12/18 * * ?")
    @Scheduled(cron="0/5 * *  * * ? ")
    public void scheduleTask(){
        heapService.scheduleHeap();
        spiderService.crawl();
        spiderService.crawlJob();
        System.out.println("schedule task");
    }


}
