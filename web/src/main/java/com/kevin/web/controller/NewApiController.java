package com.kevin.web.controller;

import com.kevin.framework.Handler.ApiServerHandler;
import com.kevin.framework.generate.packet.ApiRequestPacket;
import com.kevin.framework.serializer.Serializer;
import com.kevin.framework.serializer.protobuf.ProtobufSerializer;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by spirit on 2015/10/12.
 */
@Controller
@RequestMapping("/")
public class NewApiController {
    private Serializer serializer = new ProtobufSerializer();
    ApiServerHandler handler = new ApiServerHandler();

    @RequestMapping(value="/newapi.do",method = RequestMethod.POST)
    public void preCheck(HttpServletRequest request, HttpServletResponse response){
        InputStream inputStream = null;
        OutputStream outputStream = null;
        ApiRequestPacket reqPacket;

        response.setContentType("application/octet-stream");

        try {
            inputStream = request.getInputStream();

            String encoding = request.getHeader("Content-Encoding");
            if (StringUtils.equalsIgnoreCase("gzip", encoding)) {
                inputStream = new GZIPInputStream(inputStream);
            }
            byte[] reqData = IOUtils.toByteArray(inputStream);
            handler.setSerializer(serializer);
            byte[] respData = handler.excute(reqData);

            outputStream = response.getOutputStream();
            String acceptEncoding = request.getHeader("Accept-Encoding");
            if (StringUtils.containsIgnoreCase(acceptEncoding, "gzip") && respData.length > 1024) {
                outputStream = new GZIPOutputStream(outputStream);
                response.setHeader("Content-Encoding", "gzip");
            }
            IOUtils.write(respData, outputStream);

        } catch(Exception e){
            e.printStackTrace();
        }finally {
            closeQuietly(inputStream);
            closeQuietly(outputStream);
        }
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
