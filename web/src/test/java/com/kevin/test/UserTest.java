package com.kevin.test;


import com.kevin.dao.ClubInfoDAO;
import com.kevin.model.message.BaseNoticeMessage;
import com.kevin.model.User;

import com.kevin.model.UserInfo;
import com.kevin.model.info.BaseGroupInfo;
import com.kevin.model.info.ClubInfo;
import com.kevin.model.info.UniversityInfo;
import com.kevin.model.message.NoticeMessageWithCount;
import com.kevin.model.structure.NoticeMessageHeap;
import com.kevin.model.structure.HeapTest;
import com.kevin.service.*;
import com.kevin.service.push.SnoticePushService;
import com.kevin.service.strcuture.HeapService;
import com.kevin.web.controller.spider.GithubRepoPageProcessor;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class UserTest {

	private UserService userService;
	private BaseNoticeService baseNoticeService;
	private UniversityInfoService universityinfoService;
	private UserInfoService userInfoService;
	private HeapService heapService;
	private SpiderService spiderService;

	private UserReadService userReadService;
	private InitService initService;
	private ClubInfoService clubInfoService;
	private static Boolean b;
	private SnoticePushService snoticePushService;

	@Autowired
	private User user;

	@Autowired
	private UserInfo userInfo;

	@Before
	public void before(){                                                                    
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/ApplicationContext.xml"
				,"classpath:conf/spring-mybatis.xml"});
		userService = (UserService) context.getBean("userServiceImpl");
		baseNoticeService = (BaseNoticeService)context.getBean("baseNoticeServiceImpl");
		user = (User) context.getBean("user");
		universityinfoService = (UniversityInfoService)context.getBean("universityInfoServiceImpl");
		userInfoService = (UserInfoService)context.getBean("userInfoServiceImpl");

		spiderService = (SpiderService)context.getBean("spiderServiceImpl");
//		jobCrawler = (JobCrawler)context.getBean("jobCrawler");

		userReadService = (UserReadService)context.getBean("userReadServiceImpl");
		initService = (InitService)context.getBean("initServiceImpl");
		heapService = (HeapService)context.getBean("heapServiceImpl");
		clubInfoService = (ClubInfoService)context.getBean("clubInfoServiceImpl");
		snoticePushService = (SnoticePushService)context.getBean("snoticePushServiceImpl");
	}


	@Test
	public void testJPush(){
//		snoticePushService.test();
		List<Integer> user = new ArrayList<Integer>();
		user.add(19);
		snoticePushService.pushToUserByAlias(user, 958);
	}

	@Test
	public void testClubInfoService(){
		clubInfoService.userCreateClub(2, "testClub", "desc", 1, "img/3.jpg");
		List<BaseGroupInfo> baseGroupInfos = userInfoService.queryUserJoined(2);
	}


	@Test
	public void selectUser(){
		List<User> users = new ArrayList<User>();
		users = userService.findUser();
		for (User u:users)
			System.out.println(u.getNickname());
	}

	@Test
	 public void testInsertNoticeMsg(){
//		List<Integer> list = userReadService.getUserUnReadListByAreaId(1,4);
//		list = userReadService.getUserUnNoticeListByAreaId(1,4);

		BaseNoticeMessage callboardMessage1 = new BaseNoticeMessage();
		callboardMessage1.setUserId(1);
		callboardMessage1.setDesId(1000002);
		callboardMessage1.setSendDate(new Date());
		callboardMessage1.setCategoryId(1);
		callboardMessage1.setDate(new Date());
		callboardMessage1.setDetail("content1");
		callboardMessage1.setTitle("title1");
		callboardMessage1.setPlace("地区");
		callboardMessage1.setUp(10);
		callboardMessage1.setDown(13);
		callboardMessage1.setMsgId(10);
		int id = baseNoticeService.insertNoticeMessage(callboardMessage1);
		id = callboardMessage1.getMsgId();
		userReadService.insert(id);
	}

	@Test
	public void testBaseNoticeService(){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		List<BaseNoticeMessage> baseNoticeMessages = baseNoticeService.getNoticeMessage(1,0,10);
		List<NoticeMessageWithCount> bb = baseNoticeService.getUserSendMessage(2);
		List<BaseNoticeMessage> bbb = baseNoticeService.getUserRecvMessage(2);
		int num = baseNoticeService.getNoticeMsgCount(10, 1);
		baseNoticeMessages.add(0, new BaseNoticeMessage());
		NoticeMessageHeap noticeMessageHeap = heapService.createHeap(baseNoticeMessages);

		BaseNoticeMessage callboardMessage1 = new BaseNoticeMessage();
        callboardMessage1.setCategoryId(1);
        callboardMessage1.setDate(new Date());
        callboardMessage1.setDetail("content1");
        callboardMessage1.setTitle("title1");
        callboardMessage1.setPlace("place1");
        callboardMessage1.setSendDate(new Date());
        callboardMessage1.setUp(10);
        callboardMessage1.setDown(13);

//		noticeMessageHeap.insertHeap(callboardMessage1);

		List<BaseNoticeMessage> tmp = noticeMessageHeap.queryHeap();

		for (BaseNoticeMessage b:baseNoticeMessages){
//			String reportDate = df.format(b.getDate());
//			System.out.println(reportDate);
			System.out.println(b.getUserName());
			System.out.println(b.getCategoryId());
			System.out.println(b.getUserId());
			System.out.println(b.isVoted());
		}
	}

	@Test
	public void testDate(){
		baseNoticeService.insertNoticePraise(1,5);
	}

	@Test
	public void testSpider(){
		Spider.create(new GithubRepoPageProcessor()).addUrl("https://github.com/code4craft").addPipeline(new JsonFilePipeline("D:\\webmagic\\")).thread(5).run();
	}

	@Test
	public void testUserInfo(){
		List<BaseGroupInfo> clubInfoList = userInfoService.queryUserJoined(1);
	}
	@Test
	public void testGetUniversityInfo(){
		UniversityInfo universityInfo = universityinfoService.getUniversityInfo(1);
		for (ClubInfo c:universityInfo.getClubInfoList()){
			System.out.println(c.getName());
		}

//		SchoolInfo schoolInfo = universityinfoService.getSchoolInfo(1);
//		System.out.println(schoolInfo.getCommunityInfoList().get(0).getName());
	}

	@Test

	public void testMySpider() {
//		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/ApplicationContext.xml"
//				,"classpath:conf/spring-mybatis.xml"});
//		final JobCrawler jobCrawler = context.getBean(JobCrawler.class);
//		jobCrawler.crawl();
		spiderService.crawl();
//		spiderService.crawlJob();
//		spiderService.ruisiJob();
//		spiderService.haowangJob();
//		spiderService.haowangRoom();
//		spiderService.ruisiTrade();
//		spiderService.ruisiRoom();
	}
	@Test
	public void testLinkedHashMap(){
		System.out.println("*************************LinkedHashMap*************");
		Map<Integer,String> map = new LinkedHashMap<Integer,String>();
		map.put(6, "apple");
		map.put(3, "banana");
		map.put(2, "pear");

		for (Iterator it =  map.keySet().iterator();it.hasNext();)
		{
			Object key = it.next();
			System.out.println( key+"="+ map.get(key));
		}
	}

	@Test
	public void testjava(){
		List<BaseNoticeMessage> list = new ArrayList<BaseNoticeMessage>();
		List<ClubInfo> list2 = new ArrayList<ClubInfo>();

	}

	@Test
	public void testUserReadDAO(){
		userReadService.insert(2);
	}

	@Test
	public void testCreateTable(){
		initService.initDatabase("test_create");
	}
	@Test
	public void testUpdateUserReadMessage(){
		userReadService.update(2, 3, 1, 0, 0);
	}

	@Test
	public void testUserJoinClub(){
		userInfoService.userJoinClub(1, 1000001);
	}

	@Test
	public void testHeap(){
		HeapTest heapTest = new HeapTest();
		int test[] = new int[17];

		for (int i=1;i<test.length;i++){
			test[i] = 20-i;
		}

		int ret = heapTest.createHeap(test);
		heapTest.insertHeap(10);
		List<Integer> integers = heapTest.queryHeap();
		integers.toString();
	}

	@Test
	public void testBook(){

//		BaseNoticeMessage.NoticeMessageBuilder builder = new BaseNoticeMessage().new NoticeMessageBuilder();
//		BaseNoticeMessage baseNoticeMessage = builder.categoryId(1).categoryName("asd").build();
//
//		Field field = new Field();
//		field.b.setUserId(1);
//		baseNoticeMessage = field.getB();
	}

}
