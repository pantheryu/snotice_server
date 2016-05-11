package com.kevin.service.impl;

import com.kevin.dao.ClubInfoDAO;
import com.kevin.dao.UserInfoDAO;
import com.kevin.service.ClubInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by spirit on 2016/3/31.
 */
@Service
public class ClubInfoServiceImpl implements ClubInfoService {
    @Autowired
    ClubInfoDAO clubInfoDAO;
    @Autowired
    private UserInfoDAO userInfoDAO;

    /*
    * 首先创建club，然后加入
    * */
    public int userCreateClub(int userId,String clubName, String clubDescribe, int categoryId, String path) {

        int res = clubInfoDAO.createClub(clubName,clubDescribe,categoryId,path);
        if (res == 0)
            return -1;
        int id = clubInfoDAO.getClubIdByName(clubName);
        res = userInfoDAO.insertUserJoinedClub(userId,id);
        return res;
    }
}
