package com.kevin.service.impl;

import com.kevin.dao.UniversityInfoDAO;
import com.kevin.model.info.SchoolInfo;
import com.kevin.model.info.UniversityInfo;
import com.kevin.service.UniversityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by spirit on 2016/3/7.
 */
@Service
public class UniversityInfoServiceImpl implements UniversityInfoService {

    @Autowired
    private UniversityInfoDAO universityInfoDAO;
    public UniversityInfo getUniversityInfo(int universityId) {
        return universityInfoDAO.getUniversityInfo(universityId);
    }

    public SchoolInfo getSchoolInfo(int schoolId) {
        return universityInfoDAO.getSchools(schoolId);
    }
}
