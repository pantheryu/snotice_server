package com.kevin.dao;

import com.kevin.model.UserInfo;
import com.kevin.model.info.BaseGroupInfo;
import com.kevin.model.info.ClubInfo;
import com.kevin.model.user.UserJoinedGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by spirit on 2016/2/24.
 */
public interface UserInfoDAO {

    public List<Integer> getUserJoinedId(@Param("userId") int userId);
    public int getUserSchoolId(@Param("userId") int userId);
    public int getUserCommunityId(@Param("userId") int userId);
    public int insertUserJoinedClub(@Param("userId") int userId,@Param("clubId") int clubId);
}
