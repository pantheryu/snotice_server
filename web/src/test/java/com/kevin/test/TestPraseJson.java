package com.kevin.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.kevin.framework.common.ResultCode;
import com.kevin.model.message.BaseNoticeMessage;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by spirit on 2016/2/29.
 */
public class TestPraseJson {

    public static Type CallboradMsgType = new TypeToken<ResultCode<List<BaseNoticeMessage>>>(){
        private static final long serialVersionUID = 2879824331431686313L;
    }.getType();
    @Before
    public void before(){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/ApplicationContext.xml"
                ,"classpath:conf/spring-mybatis.xml"});

    }

    @Test
    public void praseJson(){
        String json = "{\"errMsg\":\"success\",\"errCode\":0,\"data\":[{\"msgId\":1,\"userId\":1,\"userName\":\"spirit\",\"desId\":1,\"sendDate\":\"2016-02-24 16:42\",\"title\":\"title1\",\"detail\":\"content1\",\"date\":\"2016-02-24 16:42\",\"place\":\"place1\",\"categoryId\":1,\"categoryName\":\"讲座\",\"up\":12,\"down\":13},{\"msgId\":2,\"userId\":1,\"userName\":\"spirit\",\"desId\":1,\"sendDate\":\"2016-02-24 16:50\",\"title\":\"title1\",\"detail\":\"content1\",\"date\":\"2016-02-24 16:50\",\"place\":\"place1\",\"categoryId\":1,\"categoryName\":\"讲座\",\"up\":10,\"down\":13},{\"msgId\":3,\"userId\":1,\"userName\":\"spirit\",\"desId\":1,\"sendDate\":\"2016-02-24 17:00\",\"title\":\"title1\",\"detail\":\"content1\",\"date\":\"2016-02-24 17:00\",\"place\":\"地区\",\"categoryId\":1,\"categoryName\":\"讲座\",\"up\":10,\"down\":13},{\"msgId\":4,\"userId\":1,\"userName\":\"spirit\",\"desId\":1,\"sendDate\":\"2016-02-24 17:30\",\"title\":\"title1\",\"detail\":\"content1\",\"date\":\"2016-02-24 17:30\",\"place\":\"地区\",\"categoryId\":1,\"categoryName\":\"讲座\",\"up\":10,\"down\":13},{\"msgId\":8,\"userId\":2,\"userName\":null,\"desId\":1,\"sendDate\":\"2016-02-24 20:29\",\"title\":\"title1\",\"detail\":\"content1\",\"date\":\"2016-02-24 20:29\",\"place\":\"地区\",\"categoryId\":1,\"categoryName\":\"讲座\",\"up\":10,\"down\":13},{\"msgId\":9,\"userId\":3,\"userName\":null,\"desId\":1,\"sendDate\":\"2016-02-24 20:29\",\"title\":\"title1\",\"detail\":\"content1\",\"date\":\"2016-02-24 20:29\",\"place\":\"地区\",\"categoryId\":1,\"categoryName\":\"讲座\",\"up\":10,\"down\":13},{\"msgId\":100,\"userId\":1,\"userName\":\"spirit\",\"desId\":1,\"sendDate\":\"2016-02-24 16:42\",\"title\":\"asd\",\"detail\":\"asd\",\"date\":\"2016-02-24 16:42\",\"place\":\"asd\",\"categoryId\":1,\"categoryName\":\"讲座\",\"up\":1,\"down\":1},{\"msgId\":101,\"userId\":1,\"userName\":\"spirit\",\"desId\":1,\"sendDate\":\"2016-02-24 16:42\",\"title\":\"�Ǻ�\",\"detail\":\"asd\",\"date\":\"2016-02-24 16:42\",\"place\":\"asd\",\"categoryId\":1,\"categoryName\":\"讲座\",\"up\":1,\"down\":1},{\"msgId\":102,\"userId\":1,\"userName\":\"spirit\",\"desId\":1,\"sendDate\":\"2016-02-24 16:42\",\"title\":\"����\",\"detail\":\"asd\",\"date\":\"2016-02-24 16:42\",\"place\":\"asd\",\"categoryId\":1,\"categoryName\":\"讲座\",\"up\":101,\"down\":1},{\"msgId\":105,\"userId\":1,\"userName\":\"spirit\",\"desId\":1,\"sendDate\":\"2016-02-24 16:42\",\"title\":\"qwe\",\"detail\":\"asd\",\"date\":\"2016-02-24 16:42\",\"place\":\"qwe\",\"categoryId\":1,\"categoryName\":\"讲座\",\"up\":1,\"down\":1},{\"msgId\":110,\"userId\":1,\"userName\":\"spirit\",\"desId\":1,\"sendDate\":\"2016-02-24 16:42\",\"title\":\"aaa\",\"detail\":\"aaa\",\"date\":\"2016-02-24 16:42\",\"place\":\"aaa\",\"categoryId\":1,\"categoryName\":\"讲座\",\"up\":1,\"down\":1}]}";
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
        ResultCode resultCode = (ResultCode)gson.fromJson(json,CallboradMsgType);
        List<BaseNoticeMessage> list = (List)resultCode.getData();
    }
}
