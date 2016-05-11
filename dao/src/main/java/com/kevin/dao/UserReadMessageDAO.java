package com.kevin.dao;

import com.kevin.model.UserReadMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by spirit on 2016/3/11.
 */
public interface UserReadMessageDAO {
    //插入用户对某条信息的状态
    public int insertMessage(UserReadMessage userReadMessage);
    //首先根据msgId得到areaId
    public UserReadMessage generateUserReadMessage(@Param("msgId")int msgId);
    //根据areaId得到userId的List
    public List<Integer> getGroupUserList( int desId);
    public boolean isUserRead(@Param("userId")int userId,@Param("msgId")int msgId);
    public boolean isUserNotice(@Param("userId")int userId,@Param("msgId")int msgId);
    public int updateMessage(@Param("msgId") int msgId,@Param("userId")int userId,@Param("praise") int praise,@Param("read") int read,@Param("notice") int notice);

}
