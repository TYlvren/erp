package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Technology;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyDao {
    /*删除选中的id*/
    void removeTechnologyById(@Param("id") String tid);
    //查询所有的技术信息
    List<Technology> selectTechnology();

    //检查技术名与id是否已存在
    List<Technology> selectTechnologyNameAndIDisExist(@Param("technologyId") String technologyId, @Param("technologyName") String technologyName);
    /*将所需添加的用户加入*/
    void insertTechnology(@Param("technology") Technology technology);

    void updateTechnology(@Param("technology") Technology technology);

    int selectCountOfTechnology();

    Technology findTechnologyById(@Param("id") String id);

    List<Process> selectProcess();

    List<Technology> findTechnologyNameById(@Param("technology_id") String id);

    Technology selectTechnologyNameisExist(@Param("technologyName") String technologyName);


    List<Technology> searchTechnologyByTechnologyIdOrTechnologyName(@Param("name") String name,@Param("id") String id);
}