package com.kevin.framework;

import com.kevin.framework.common.ResultCode;
import com.kevin.framework.generate.packet.LivePicMessage;
import com.kevin.framework.generate.packet.LivePicMessageList;
import com.kevin.framework.generate.test.testPara;
import com.kevin.framework.utils.PathUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spirit on 2015/10/8.
 */
public class ApiServiceImpl implements ApiService {

    public testPara sayHello(testPara para) {
        testPara result = new testPara();
        result.setA("hello world");
        result.setB("funck");
        return result;
    }

    public LivePicMessageList fetchLivePic() {
        LivePicMessageList result = new LivePicMessageList();
        List<LivePicMessage> list = new ArrayList<LivePicMessage>();
        LivePicMessage livePicInfo1 = new LivePicMessage();
        livePicInfo1.setPicStoreUrl(PathUtils.SERVER_PATH + "img/1.jpg");
        livePicInfo1.setPicInfoUrl(PathUtils.SERVER_PATH);
        list.add(livePicInfo1);

        LivePicMessage livePicInfo2 = new LivePicMessage();
        livePicInfo2.setPicStoreUrl(PathUtils.SERVER_PATH + "img/2.jpg");
        livePicInfo2.setPicInfoUrl(PathUtils.SERVER_PATH);
        list.add(livePicInfo2);
        result.setPicListList(list);
        return result;
    }
}
