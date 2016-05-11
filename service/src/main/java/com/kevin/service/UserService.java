package com.kevin.service;


import com.kevin.model.User;

import java.util.List;

/**
 * Created by spirit on 2015/10/2.
 * this is just a test demo!!
 */
public interface  UserService {
    public int insertUser(User user);
    public List<User> findUser();
    public User getUserById(int id);
    public int updateUser(User user);
}
