package com.kevin.dao;

import com.kevin.model.info.CommunityInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by spirit on 2016/3/7.
 */
public interface CommunityDAO {
    public CommunityInfo selectCommunityInfo(@Param("communityId") int communityId);
}
