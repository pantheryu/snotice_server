package com.kevin.framework.builder;

import com.dyuproject.protostuff.ByteString;
import com.kevin.framework.error.ApiErrorCodes;
import com.kevin.framework.error.ApiException;
import com.kevin.framework.generate.packet.ApiResponsePacket;
import com.kevin.framework.generate.packet.ApiResultPacket;
import com.kevin.framework.serializer.Serializer;
import com.kevin.framework.serializer.protobuf.ProtobufSerializer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spirit on 2015/10/10.
 */
public class ApiResponseBuilder {
    private Serializer serializer;
    private List<ApiResultPacket> resultList = new ArrayList<ApiResultPacket>();
    private int errCode;
    private String errMsg;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Serializer getSerializer() {
        return serializer;
    }

    public void setSerializer(Serializer serializer) {
        this.serializer = serializer;
    }
    public void addSuccessResult(int num,Object ret){
        ApiResultPacket apiResultPacket = new ApiResultPacket();
        apiResultPacket.setRequestNumber(num);
        apiResultPacket.setErrorCode(0);
        apiResultPacket.setErrorMessage("success");
        apiResultPacket.setReturnValue(ByteString.copyFrom(serializer.serialize(ret)));
        resultList.add(apiResultPacket);
    }

    public void addFailureResult(int num,Exception e){
        ApiResultPacket apiResultPacket = new ApiResultPacket();
        apiResultPacket.setRequestNumber(num);
        int errcode = ApiErrorCodes.UNKNOWN.getValue();
        if (e instanceof ApiException){
            errcode = ((ApiException)e).getErrorCode();
        }
        apiResultPacket.setErrorCode(errcode);
        apiResultPacket.setErrorMessage(e.getMessage());
        resultList.add(apiResultPacket);
    }

    public ApiResponsePacket toPacket(Serializer serializer){
        ApiResponsePacket packet = new ApiResponsePacket();
        packet.setApiResultsList(resultList);
        return packet;
    }
}
