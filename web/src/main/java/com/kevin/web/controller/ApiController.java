package com.kevin.web.controller;

import com.dyuproject.protostuff.ByteString;
import com.kevin.framework.generate.test.ApiRestPacket;
import com.kevin.framework.generate.test.ApiTest;
import com.kevin.framework.serializer.Serializer;
import com.kevin.framework.serializer.protobuf.ProtobufSerializer;
import com.kevin.framework.ApiServiceImpl;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by spirit on 2015/10/8.
 */
@Controller
public class ApiController {


    private Serializer serializer = new ProtobufSerializer();

    @RequestMapping(value="/api.do",method = RequestMethod.POST)
    public void preCheck(HttpServletRequest request, HttpServletResponse response){
        InputStream inputStream = null;
        OutputStream outputStream = null;

        response.setContentType("application/octet-stream");

        try {
            inputStream = request.getInputStream();

            String encoding = request.getHeader("Content-Encoding");
            if (StringUtils.equalsIgnoreCase("gzip", encoding)) {
                inputStream = new GZIPInputStream(inputStream);
            }
            byte[] reqData = IOUtils.toByteArray(inputStream);

            ApiTest reqPacket = serializer.deserialize(ApiTest.class, reqData);
            int num = reqPacket.getReqNum();
            String methodName = reqPacket.getMethodName();
            List<ByteString> list = reqPacket.getParameterList();
            ApiServiceImpl apiService = new ApiServiceImpl();
            Method[] methods = apiService.getClass().getMethods();
            Method method = null;

            for (Method m:methods){
                if (m.getName().equals(methodName)){
                    method = m;
                    break;
                }
            }
            Object object = null;
            List<Object> objList = new ArrayList<Object>();
            Class[] parameterTypes = method.getParameterTypes();
            byte[] bytes = null;
            for (int i =0;i<list.size();i++){
                bytes = list.get(i).toByteArray();
                object = serializer.deserialize(parameterTypes[i],bytes);
                objList.add(object);
            }
            Object[] objects = objList.toArray();
            Object ret = method.invoke(apiService, objects);
            ApiRestPacket respPacket = new ApiRestPacket();
            respPacket.setErrCode(0);
            respPacket.setReqNum(1);
            respPacket.setErrMsg("success");
            respPacket.setParameter(ByteString.copyFrom(serializer.serialize(ret)));


            outputStream = response.getOutputStream();
            byte[] respData = serializer.serialize(respPacket);
            String acceptEncoding = request.getHeader("Accept-Encoding");
            if (StringUtils.containsIgnoreCase(acceptEncoding, "gzip") && respData.length > 1024) {
                outputStream = new GZIPOutputStream(outputStream);
                response.setHeader("Content-Encoding", "gzip");
            }
            IOUtils.write(respData, outputStream);

//            Object[] object = method.getParameterTypes();
//            Object parameter = serializer.deserialize(method.getParameterTypes()[0], reqPacket.getParameter().toByteArray());
//            Object str = method.invoke(apiService,parameter);
//
//            String str1 = str.toString();
//            String str2 = null;

//            byte[] respData = handler.execute(reqData);
//
//            outputStream = response.getOutputStream();
//            String acceptEncoding = request.getHeader("Accept-Encoding");
//            if (StringUtils.containsIgnoreCase(acceptEncoding, "gzip") &&
//                    respData.length > 1024) {
//                outputStream = new GZIPOutputStream(outputStream);
//                response.setHeader("Content-Encoding", "gzip");
//            }
//
//
//            IOUtils.write(respData, outputStream);
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            closeQuietly(inputStream);
            closeQuietly(outputStream);
        }
    }

    @RequestMapping(value="/apis.do",method = RequestMethod.GET)
    public String preGet(HttpServletRequest request, HttpServletResponse response){
        return "success";
    }

    private void closeQuietly(Closeable closeable) {

        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            // do nothing
        }
    }
}
