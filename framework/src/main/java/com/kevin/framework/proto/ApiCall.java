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
     * ������.
     * @return
     */
    public int getRequestNo() {
        return requestNo;
    }

    /**
     * API����.
     * @return
     */
    public String getApiName() {
        return apiName;
    }

    /**
     * API����.
     * ע��ֻ֧��һ���������Ҹò���Ӧ��protobuf message����.
     * @return
     */
    public Object getParameter() {
        return parameter;
    }
}
