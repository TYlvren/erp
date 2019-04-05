package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Material;
import com.cskaoyan.erp.model.MaterialConsume;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface MaterialConsumeDao {
    List<MaterialConsume> selectAll();
    int addMaterialConsume(@Param("materialConsume") MaterialConsume materialConsume);
    List<Material> selectMaterialId();
    int deleteById(@Param("id") String id);
    int updateConsume(@Param("materialConsume") MaterialConsume materialConsume);
    int updateConsumeNote(@Param("materialConsume") MaterialConsume materialConsume);
    List<MaterialConsume> selectLikeConsumeId(String materialId);
    List<MaterialConsume> selectLikeMaterialId(String receiveId);
    List<MaterialConsume> selectLikeWorkId(String receiveId);
}