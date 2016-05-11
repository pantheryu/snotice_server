package com.kevin.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by spirit on 2016/3/14.
 */
public interface InitDatabaseDAO {
    public int createTable(@Param("table_name")String tableName);
}
