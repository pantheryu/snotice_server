package com.kevin.service.impl;

import com.kevin.dao.InitDatabaseDAO;
import com.kevin.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by spirit on 2016/3/14.
 */
@Service
public class InitServiceImpl implements InitService {

    @Autowired
    private InitDatabaseDAO initDatabaseDAO;

    public int initDatabase(String tableName) {
        return initDatabaseDAO.createTable(tableName);
    }
}
