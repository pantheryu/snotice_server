package com.kevin.framework.common;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by spirit on 2015/10/2.
 */
public class ResultCode<T> implements Serializable {
    private String errMsg;
    private int errCode;
    private T data;

    public ResultCode() {
        this.errMsg = "success";
        this.errCode = 0;
        this.data = null;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

   public String toString(){
       return ToStringBuilder.reflectionToString(this);
   }
}
