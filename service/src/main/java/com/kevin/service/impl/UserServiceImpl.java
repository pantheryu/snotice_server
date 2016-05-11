package com.kevin.service.impl;

import com.kevin.dao.UserDAO;
import com.kevin.model.User;
import com.kevin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by spirit on 2015/10/2.
 * this is just a test demo
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private User user;

    public int insertUser(User user) {
        // TODO Auto-generated method stub
        return userDAO.insertUser(user);
    }

    public List<User> findUser() {
        return userDAO.finduserById();
    }

    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    public int updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public int getUserIdByName(String username, String password) {
        return userDAO.getUserIdByName(username, password);
    }

    public int checkUserByName(String username, String password){
        return userDAO.checkUserByName(username, password);
    }

    public Date getTokenTimeByToken(String token){
        return userDAO.getTokenTimeByToken(token);
    }

    public User getUserByToken(String token){
        return userDAO.getUserByToken(token);
    }

    public int getUserIdByToken(String token){
        return userDAO.getUserIdByToken(token);
    }

    public String getAliasnameById(int userid){return userDAO.getAliasnameById(userid); }
}
