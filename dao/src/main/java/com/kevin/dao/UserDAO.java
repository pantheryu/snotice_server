package com.kevin.dao;

import com.kevin.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by spirit on 2015/10/2.
 */

public interface UserDAO {
    /**
     *
     * @param user
     * @return
     */
    public int insertUser(User user);
    public List<User> finduserById();
    public int getUserIdByName(@Param("username") String username, @Param("password")String password);
    public int updateUser(User user);
    public User getUserById(@Param("id")int id);
    public int checkUserByName(@Param("username") String username, @Param("password")String password);
    public Date getTokenTimeByToken(@Param("token")String token);

    public User getUserByToken(@Param("token")String token);
    public int getUserIdByToken(@Param("token")String token);

    public String getAliasnameById(@Param("userid")int userid);
}
