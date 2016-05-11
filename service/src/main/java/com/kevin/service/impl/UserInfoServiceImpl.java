package com.kevin.service.impl;

import com.kevin.dao.ClubInfoDAO;
import com.kevin.dao.CommunityDAO;
import com.kevin.dao.SchoolInfoDAO;
import com.kevin.dao.UserInfoDAO;
import com.kevin.model.info.BaseGroupInfo;
import com.kevin.model.info.ClubInfo;
import com.kevin.model.info.CommunityInfo;
import com.kevin.model.info.SchoolInfo;
import com.kevin.model.user.UserJoinedGroup;
import com.kevin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spirit on 2016/3/7.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDAO userInfoDAO;
    @Autowired
    private ClubInfoDAO clubInfoDAO;
    @Autowired
    private SchoolInfoDAO schoolInfoDAO;
    @Autowired
    private CommunityDAO communityDAO;


    public List<BaseGroupInfo> queryUserJoined(int userId) {

        List<BaseGroupInfo> result = new ArrayList<BaseGroupInfo>();

        List<Integer> list = userInfoDAO.getUserJoinedId(userId);
        List<ClubInfo> clubInfoList = new ArrayList<ClubInfo>();
        for (int i:list){
            clubInfoList.add(clubInfoDAO.selectClub(i));
        }

        SchoolInfo schoolInfo = schoolInfoDAO.selectSchoolInfo(userInfoDAO.getUserSchoolId(userId));
        CommunityInfo communityInfo = communityDAO.selectCommunityInfo(userInfoDAO.getUserCommunityId(userId));

        result.addAll(clubInfoList);
        if(schoolInfo == null)
            result.add(schoolInfo);

        if (communityInfo == null)
            result.add(communityInfo);

        return result;
    }

    public int userJoinClub(int userId, int clubId) {
        return userInfoDAO.insertUserJoinedClub(userId,clubId);
    }
}
