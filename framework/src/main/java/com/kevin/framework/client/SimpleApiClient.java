package com.kevin.framework.client;

import com.dyuproject.protostuff.ByteString;
import com.kevin.framework.error.ApiErrorCodes;
import com.kevin.framework.error.ApiException;
import com.kevin.framework.generate.test.ApiReqPacket;
import com.kevin.framework.generate.test.ApiRestPacket;
import com.kevin.framework.generate.test.ApiTest;
import com.kevin.framework.packet.CommHttpPacket;
import com.kevin.framework.serializer.Serializer;
import org.apache.commons.io.IOUtils;


import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by spirit on 2015/10/8.
 */
public class SimpleApiClient implements InvocationHandler{

    private static final String USER_AGENT = "ApiClient 1.0";
    private static final String CHARSET = "UTF-8";

    private String apiUri;
    private Serializer serializer;
    private String header = "Snotice";
    private String body = null;
//    private SignatureManager signatureManager;

    public SimpleApiClient(String apiUri, Serializer serializer) {

        this.apiUri = apiUri;
        this.serializer = serializer;
    }

    public <T> T getService(Class<T> serviceInterface) {

        if (!serviceInterface.isInterface()) {
            throw new IllegalArgumentException("serviceInterface must be of interface type!");
        }

        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{serviceInterface}, this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        URL url = new URL(this.apiUri);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.setRequestProperty("Accept-Charset", CHARSET);
        conn.setRequestProperty("Content-Type", "binary;charset=" + CHARSET);

        conn.setRequestProperty("Accept-Encoding", "gzip");
        conn.setRequestProperty("Content-Encoding", "gzip");

        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        OutputStream outputStream = null;
        InputStream inputStream = null;
        Object object = null;

        try {
            outputStream = new GZIPOutputStream(conn.getOutputStream());
            ApiTest requestPacket = new ApiTest();
            requestPacket.setReqNum(1);
            requestPacket.setMethodName(method.getName());
            List<ByteString> para = new ArrayList<ByteString>();
            for (Object obj:args){
                para.add(ByteString.copyFrom(serializer.serialize(obj)));
            }
            requestPacket.setParameterList(para);

            serializer.serialize(requestPacket, outputStream);
            // flush the stream
            closeQuietly(outputStream);

            //����������
            inputStream = conn.getInputStream();


            String encoding = conn.getHeaderField("Content-Encoding");
            if(encoding != null && encoding.contains("gzip")) {
                inputStream = new GZIPInputStream(inputStream);
            }

            byte[] data = IOUtils.toByteArray(inputStream);
            ApiRestPacket req = serializer.deserialize(ApiRestPacket.class, data);
            int errCode = req.getErrCode();

            object = serializer.deserialize(method.getReturnType(),req.getParameter().toByteArray());
        } catch (Exception e){
          e.printStackTrace();
        } finally {

            closeQuietly(inputStream);
            closeQuietly(outputStream);
        }
        return object;
    }

    private void closeQuietly(Closeable closeable) {

        try {
            if(closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            // do nothing
        }
    }
}
