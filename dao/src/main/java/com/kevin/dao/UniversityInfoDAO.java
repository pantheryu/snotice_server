package com.kevin.dao;

import com.kevin.model.info.SchoolInfo;
import com.kevin.model.info.UniversityInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by spirit on 2016/3/4.
 */
public interface UniversityInfoDAO {
    public UniversityInfo getUniversityInfo(@Param("universityId") int universityId);
    public SchoolInfo getSchools(@Param("schoolId") int schoolId);
}
