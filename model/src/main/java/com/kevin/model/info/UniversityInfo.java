package com.kevin.model.info;

import java.util.List;

/**
 * Created by spirit on 2015/12/5.
 * 学校信息
 */
public class UniversityInfo extends BaseGroupInfo{
    private List<SchoolInfo> schoolInfoList;
    private List<ClubInfo> clubInfoList;

    public List<ClubInfo> getClubInfoList() {
        return clubInfoList;
    }

    public void setClubInfoList(List<ClubInfo> clubInfoList) {
        this.clubInfoList = clubInfoList;
    }

    public List<SchoolInfo> getSchoolInfoList() {
        return schoolInfoList;
    }

    public void setSchoolInfoList(List<SchoolInfo> schoolInfoList) {
        this.schoolInfoList = schoolInfoList;
    }
}
