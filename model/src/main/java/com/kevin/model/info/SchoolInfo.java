package com.kevin.model.info;

import java.util.List;

/**
 * Created by spirit on 2016/3/4.
 */
public class SchoolInfo extends BaseGroupInfo {
    private List<CommunityInfo> communityInfoList;

    public List<CommunityInfo> getCommunityInfoList() {
        return communityInfoList;
    }

    public void setCommunityInfoList(List<CommunityInfo> cummunityInfoList) {
        this.communityInfoList = cummunityInfoList;
    }
}
