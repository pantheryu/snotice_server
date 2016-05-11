package com.kevin.service;

import com.kevin.model.info.SchoolInfo;
import com.kevin.model.info.UniversityInfo;

/**
 * Created by spirit on 2016/3/7.
 */
public interface UniversityInfoService {
    public UniversityInfo getUniversityInfo(int universityId);
    public SchoolInfo getSchoolInfo(int schoolId);
}
