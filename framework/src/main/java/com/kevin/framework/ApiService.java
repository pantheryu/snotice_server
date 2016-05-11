package com.kevin.framework;

import com.kevin.framework.generate.packet.LivePicMessage;
import com.kevin.framework.generate.packet.LivePicMessageList;
import com.kevin.framework.generate.test.testPara;

import java.util.List;

/**
 * Created by spirit on 2015/10/8.
 */
public interface ApiService {
    public testPara sayHello(testPara para);
    public LivePicMessageList fetchLivePic();

}
