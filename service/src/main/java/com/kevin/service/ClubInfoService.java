package com.kevin.service;

import org.apache.ibatis.annotations.Param;

/**
 * Created by spirit on 2016/3/31.
 */
public interface ClubInfoService {
    public int userCreateClub(int userId,String clubName, String clubDescribe,int categoryId, String path);
}
