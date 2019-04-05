package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.TechnologyRequirement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyRequirementDao {
    List<TechnologyRequirement> selectTechnologyRequirement();

    Integer selectCountOfTechnologyRequirement();

    int addTechnologyRequirement(@Param("tRequirement") TechnologyRequirement technologyRequirement);

    TechnologyRequirement technologyRequirementIdIsexist(@Param("technologyRequirementId") String technologyRequirementId);

    void removeTechnologyRequirementById(@Param("id") String tid);

    int updateTechnology(@Param("tRequirement") TechnologyRequirement technologyRequirement);

    List<TechnologyRequirement> selectTechnologyRequirement2();
}