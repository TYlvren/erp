package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Material;
import com.cskaoyan.erp.model.MaterialReceive;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialReceiveDao {
    /*-------------物料收入模块------------------------------------------------*/
    List<MaterialReceive> selectMaterialReceive();
    int addMaterialReceive(@Param("materialReceive") MaterialReceive materialReceive);
    List<Material> selectMaterialId();
    int deleteById(@Param("id") String id);
    // 动态修改物料信息
    int update(@Param("materialReceive") MaterialReceive materialReceive);
    int updateNote(@Param("materialReceive") MaterialReceive materialReceive);
    int CountOfMaterialReceive();
}