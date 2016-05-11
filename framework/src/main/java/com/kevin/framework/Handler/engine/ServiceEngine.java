package com.kevin.framework.Handler.engine;

import com.kevin.framework.ApiService;
import com.kevin.framework.ApiServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by spirit on 2015/10/13.
 */
/**
 * @Author:spirit
 * serviceEngine�Ǹ���������Ҫ�ڹ��캯������ǰע��ӿں�ʵ����
 * */
public class ServiceEngine {
    private static Map<String,String> serviceMap;
    private static class ServiceEngineSingletonHolder{
        private static final ServiceEngine INSTANCE = new ServiceEngine();
    }
    private ServiceEngine(){
        serviceMap = new HashMap<String, String>();
        serviceMap.put(ApiService.class.getName(), ApiServiceImpl.class.getName());
    }
    public static final ServiceEngine getInstance(){
        return ServiceEngineSingletonHolder.INSTANCE;
    }
    public Object getService(String interfaceName){
        Object obj = null;
        String str = serviceMap.get(interfaceName);
        try {
            obj = Class.forName(str).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }
}
