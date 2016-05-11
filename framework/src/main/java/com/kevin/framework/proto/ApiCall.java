package com.kevin.framework.proto;

/**
 * Created by spirit on 2015/10/10.
 */
public class ApiCall {
    private int requestNo = 1;
    private String apiName;
    private Object parameter;

    public ApiCall(int requestNo, String apiName, Object parameter) {
        this.requestNo = requestNo;
        this.apiName = apiName;
        this.parameter = parameter;
    }

    /**
     * 请求编号.
     * @return
     */
    public int getRequestNo() {
        return requestNo;
    }

    /**
     * API名称.
     * @return
     */
    public String getApiName() {
        return apiName;
    }

    /**
     * API参数.
     * 注：只支持一个参数，且该参数应是protobuf message类型.
     * @return
     */
    public Object getParameter() {
        return parameter;
    }
}
