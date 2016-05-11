package com.kevin.framework.packet;

/**
 * Created by spirit on 2015/10/8.
 */
public class CommHttpPacket {
    private String header;
    private Object[] body;

    public CommHttpPacket(String header,Object[] body){
        this.header = header;
        this.body = body;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object[] body) {
        this.body = body;
    }
}
