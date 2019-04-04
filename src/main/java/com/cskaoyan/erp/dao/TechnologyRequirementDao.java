package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.TechnologyRequirement;

import java.util.List;

public interface TechnologyRequirementDao {
    List<TechnologyRequirement> selectTechnologyRequirement();


    int selectCountOfTechnologyRequirement();
}