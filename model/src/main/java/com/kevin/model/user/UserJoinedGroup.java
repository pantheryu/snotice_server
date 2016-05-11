package com.kevin.model.user;

import com.kevin.model.info.BaseGroupInfo;
import com.kevin.model.info.ClubInfo;
import com.kevin.model.info.CommunityInfo;
import com.kevin.model.info.SchoolInfo;

import java.util.List;

/**
 * Created by spirit on 2016/3/7.
 */
public class UserJoinedGroup {

    private List<ClubInfo> clubInfoList;

    public List<ClubInfo> getClubInfoList() {
        return clubInfoList;
    }

    public void setClubInfoList(List<ClubInfo> clubInfoList) {
        this.clubInfoList = clubInfoList;
    }
}
