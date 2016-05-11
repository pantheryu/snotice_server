package com.kevin.framework.Handler;

import com.kevin.framework.error.ApiErrorCodes;
import com.kevin.framework.error.ApiException;
import com.kevin.framework.generate.packet.ApiRequestPacket;
import com.kevin.framework.generate.packet.ApiResponsePacket;
import com.kevin.framework.serializer.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by spirit on 2015/10/10.
 */
public class ApiServerHandler {
    public Serializer getSerializer() {
        return serializer;
    }

    public void setSerializer(Serializer serializer) {
        this.serializer = serializer;
    }

    private Serializer serializer ;
    private ApiRequestHandler apiRequestHandler;
    private static final Logger log = LoggerFactory
            .getLogger(ApiServerHandler.class);
    private ApiRequestHandler handler = new ApiRequestHandler();

    public ApiRequestHandler getApiRequestHandler() {
        return apiRequestHandler;
    }

    public void setApiRequestHandler(ApiRequestHandler apiRequestHandler) {
        this.apiRequestHandler = apiRequestHandler;
    }

    /**
     * 这一层主要是对ApiRequestPacket和ApiResponsePacket操作，拆包逐个执行，
     * 将返回结构组成ApiResponsePacket，设置错误码，反序列化，返回字节流。
     * */
    public byte[] excute(byte[] data){
        ApiRequestPacket request = null;
        ApiResponsePacket response ;
        try {
            request = serializer.deserialize(ApiRequestPacket.class, data);

            //verify
            if (request.getApiVer() != null && request.getApiVer() >= 2) {
                verirySign(request);
            }

            handler.setSerializer(serializer);
            response = handler.execute(request);

        } catch (Exception e){
            response = new ApiResponsePacket();
            if (e instanceof ApiException) {
                response.setErrorCode(((ApiException) e).getErrorCode());
            } else {
                response.setErrorCode(ApiErrorCodes.UNKNOWN.getValue());
            }
            response.setErrorMessage(e.getMessage());
            if (request != null) {
                response.setLongTermSessionID(request.getLongTermSessionID());
            }
            log.error("api error", e);
        }
        return serializer.serialize(response);
    }

    /**
     * 对发送过来的包进行签名运算
     * */
    private void verirySign(ApiRequestPacket apiRequestPacket){
        //verify sign in requestPacket
    }
}
