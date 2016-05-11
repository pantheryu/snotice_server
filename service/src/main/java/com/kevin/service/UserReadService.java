package com.kevin.service;

import java.util.List;

/**
 * Created by spirit on 2016/3/11.
 */
public interface UserReadService {
    /*
    * 插入任何一条消息都对应生成响应的读取状态表
    * */
    public int insert(int msgId);
    public int update(int msgId,int userId,int praise,int read,int notice);
    public List<Integer> getUserListByAreaId(int areaId);

    public List<Integer> getUserUnReadListByAreaId(int areaId,int msgId);

    public List<Integer> getUserUnNoticeListByAreaId(int areaId,int msgId);

}
