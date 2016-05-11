package com.kevin.service.impl.Spider;



import com.kevin.model.info.spider.*;
import com.kevin.service.Piepline.RuisiJobPipeline;
import com.kevin.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by PantherYu on 2016/3/14.
 */
@Service
public class SpiderServiceImpl implements SpiderService {


    @Qualifier("lecturePipeline")
    @Autowired
    private PageModelPipeline lectureInfoPipeline;

    @Qualifier("jobPipeline")
    @Autowired
    private PageModelPipeline jobInfoPipeline;

    @Qualifier("ruisiJobPipeline")
    @Autowired
    private PageModelPipeline ruisiJobPipeline;

    @Qualifier("haowangJobPipeline")
    @Autowired
    private PageModelPipeline haowangJobPipeline;

    @Qualifier("haowangRoomPipeline")
    @Autowired
    private PageModelPipeline haowangRoomPipeline;

    @Qualifier("ruisiTradePipeline")
    @Autowired
    private PageModelPipeline ruisiTradePipeline;

    @Qualifier("ruisiRoomPipeline")
    @Autowired
    private PageModelPipeline ruisiRoomPipeline;

    @Override
    public void crawl() {
        OOSpider.create(Site.me().setCharset("UTF-8").setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36"),lectureInfoPipeline, LectureInfo.class)
                .addUrl("http://meeting.xidian.edu.cn/html/lectures")
                .thread(5)
                .run();
    }

    public void crawlJob() {
        OOSpider.create(Site.me().setCharset("gb2312").setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36"),jobInfoPipeline, JobInfo.class)
//                .addUrl("http://job.xidian.edu.cn/html/zpxx/jobs")
                .addUrl("http://job.xidian.edu.cn/html/zpxx/jobs/list_3_1.html")
                .thread(5)
                .run();
    }

    public void ruisiJob() {
        OOSpider.create(Site.me().setCharset("UTF-8"), ruisiJobPipeline, RuisiJobInfo.class)
                .addUrl("http://rs.xidian.edu.cn/forum.php?mod=forumdisplay&fid=554")
                .thread(5)
                .run();
    }

    public void haowangJob() {
        OOSpider.create(Site.me().setCharset("gbk").setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36"),haowangJobPipeline, HaowangJobInfo.class)
                .addUrl("http://club.xdnice.com/forum-113-1.html")
                .thread(5)
                .run();
    }

    public void haowangRoom() {
        OOSpider.create(Site.me().setCharset("gbk").setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36"),haowangRoomPipeline, HaowangRoomInfo.class)
                .addUrl("http://club.xdnice.com/forum-118-1.html")
                .thread(5)
                .run();
    }

    public void ruisiTrade() {
        OOSpider.create(Site.me().setCharset("UTF-8"), ruisiJobPipeline, RuisiJobInfo.class)
                .addUrl("http://rs.xidian.edu.cn/forum.php?mod=forumdisplay&fid=110")
                .thread(5)
                .run();
    }

    public void ruisiRoom() {
        OOSpider.create(Site.me().setCharset("UTF-8"), ruisiRoomPipeline, RuisiRoomInfo.class)
                .addUrl("http://rs.xidian.edu.cn/forum.php?mod=forumdisplay&fid=546")
                .thread(5)
                .run();
    }
}
