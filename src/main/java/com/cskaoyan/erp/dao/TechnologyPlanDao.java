package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.TechnologyPlan;
import com.cskaoyan.erp.model.TechnologyRequirement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyPlanDao {

    int selectCountOfTechnologyPlan();

    List<TechnologyPlan> selectTechnologyPlan();

    List<TechnologyPlan> selectTechnology();

    List<TechnologyPlan> technologyPlanIdIsexist(@Param("technologyPlanId") String id);

    void addTechnologyPlan(@Param("technologyplan") TechnologyPlan technologyPlan);

    void removeTechnologyPlanById(String tid);

    int updateTechnologyPlan(@Param("technologyplan") TechnologyPlan technologyPlan);


    TechnologyPlan findTechnologyPlanById(@Param("id") String id);
}