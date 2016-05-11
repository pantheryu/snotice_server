package com.kevin.dao;

import com.kevin.model.info.ClubInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by spirit on 2016/3/7.
 */
public interface ClubInfoDAO {
    public ClubInfo selectClub(@Param("clubId") int clubId);
    public int createClub(@Param("name")String clubName,@Param("desc") String clubDescribe,@Param("categoryId") int categoryId,@Param("path") String path);
    public int getClubIdByName(@Param("name")String clubName);
}
