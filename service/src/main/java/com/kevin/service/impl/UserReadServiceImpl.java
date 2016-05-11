package com.kevin.service.impl;

import com.kevin.dao.UserReadMessageDAO;
import com.kevin.model.UserReadMessage;
import com.kevin.service.UserReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by spirit on 2016/3/11.
 */
@Service
public class UserReadServiceImpl implements UserReadService {

    @Autowired
    private UserReadMessageDAO userReadMessageDAO;

    public int insert(int msgId) {

        UserReadMessage userReadMessage = userReadMessageDAO.generateUserReadMessage(msgId);
        List<Integer> list = userReadMessageDAO.getGroupUserList(userReadMessage.getAreaId());
        for (int user : list){
            userReadMessage.setUserId(user);
            userReadMessageDAO.insertMessage(userReadMessage);
        }
        return 0;
    }

    public int update(int msgId,int userId, int praise, int read, int notice) {
        return userReadMessageDAO.updateMessage(msgId,userId,praise,read,notice);
    }

    public List<Integer> getUserListByAreaId(int areaId) {
        return userReadMessageDAO.getGroupUserList(areaId);
    }

    @Override
    public List<Integer> getUserUnReadListByAreaId(int areaId,int msgId) {
        List<Integer> userIdList = userReadMessageDAO.getGroupUserList(areaId);

        for(Iterator<Integer> it = userIdList.iterator();it.hasNext();){
            int userId = it.next();
            if(userReadMessageDAO.isUserRead(userId,msgId)){
                it.remove();
            }
        }
        return userIdList;
    }

    @Override
    public List<Integer> getUserUnNoticeListByAreaId(int areaId,int msgId) {
        List<Integer> userIdList = userReadMessageDAO.getGroupUserList(areaId);
        for(Iterator<Integer> it = userIdList.iterator();it.hasNext();){
            int userId = it.next();
            if(userReadMessageDAO.isUserNotice(userId,msgId)){
                it.remove();
            }
        }
        return userIdList;
    }
}
