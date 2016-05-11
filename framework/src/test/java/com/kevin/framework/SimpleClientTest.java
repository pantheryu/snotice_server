package com.kevin.framework;

//import com.kevin.framework.client.NewApiClient;
//import com.kevin.framework.client.SimpleApiClient;
//import com.kevin.framework.generate.test.testPara;
//import com.kevin.framework.serializer.Serializer;
//import com.kevin.framework.serializer.protobuf.ProtobufSerializer;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.lang.reflect.Method;
//import java.lang.reflect.Modifier;


/**
 * Created by spirit on 2015/10/8.
 */
public class SimpleClientTest {
//    private static final String apiUri = "http://localhost:8080/api.do"; //daily server
//    private static final String newApiUri = "http://localhost:8080/newapi.do";//new
//    private Serializer serializer = new ProtobufSerializer();
//    private SimpleApiClient client = null;
//    private ApiService apiServie = null;
//    private ApiService newApiService = null;
//    private NewApiClient newClient = null;
//
//
//    @Before
//    public void setUp(){
//        client = new SimpleApiClient(apiUri,serializer);
//        newClient = new NewApiClient(newApiUri,serializer);
//        apiServie = client.getService(ApiService.class);
//        newApiService = newClient.getService(ApiService.class);
//    }
//
//    @Test
//    public void testApi(){
//        ApiService apiService = new ApiServiceImpl();
//        try{
//            Class clzz = apiService.getClass();
//            Method[] methods = clzz.getMethods();
//            Method method = null;
//            for (Method m:methods){
//                if (m.getName().equals("sayHello")){
//                    method = m;
//                    break;
//                }
//
//            }
//            Object[] obj = {1,"h"};
//            Object ret = method.invoke(apiService, obj);
//            System.out.println(ret.toString());
//
////            Method method = apiService.getClass().getDeclaredMethod("sayHello");
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//
//    @Test
//    public void testPb(){
//        testPara para = new testPara();
//        para.setA("a");
//        para.setB("b");
//        testPara res = apiServie.sayHello(para);
//        System.out.println(res.getA());
//    }
//
//
//    @Test
//    //�µĹ��ܲ���
//    public void testNewApiPb(){
//        testPara para = new testPara();
//        para.setA("a");
//        para.setB("b");
//        testPara res = newApiService.sayHello(para);
//        System.out.println(res.getA());
//    }
//
//    @Test
//    public void testCreateFrom(){
//        int a = 32;
//        Class clzz = Integer.class;
//        if (clzz.isInterface() )
//            System.out.println("hehe ");
//        else if ( Modifier.isAbstract(clzz.getModifiers()))
//            System.out.println("asdas");
//        else
//            System.out.println("shit");
//    }
}
