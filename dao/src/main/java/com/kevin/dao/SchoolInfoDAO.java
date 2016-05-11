package com.kevin.dao;

import com.kevin.model.info.SchoolInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by spirit on 2016/3/7.
 */
public interface SchoolInfoDAO {
    public SchoolInfo selectSchoolInfo(@Param("schoolId") int schoolId);
}
