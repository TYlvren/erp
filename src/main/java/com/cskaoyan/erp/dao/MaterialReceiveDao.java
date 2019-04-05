package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Material;
import com.cskaoyan.erp.model.MaterialReceive;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialReceiveDao {
    /*-------------物料收入模块------------------------------------------------*/
    List<MaterialReceive> selectAll();
    int addMaterialReceive(@Param("materialReceive") MaterialReceive materialReceive);
    List<Material> selectMaterialId();
    int deleteById(@Param("id") String id);
    int updateReceive(@Param("materialReceive") MaterialReceive materialReceive);
    int updateReceiveNote(@Param("materialReceive") MaterialReceive materialReceive);
    List<MaterialReceive> selectLikeMaterialId(String materialId);
    List<MaterialReceive> selectLikeReceiveId(String receiveId);
}