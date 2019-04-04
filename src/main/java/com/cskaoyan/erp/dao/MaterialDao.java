package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Material;
import com.cskaoyan.erp.model.MaterialReceive;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description: MaterialMapper接口
 * @version V1.0
 */
public interface MaterialDao {
    // 查询所有物料信息
    List<Material> selectMaterial();

    int count();

    // 新增物料信息
    int addMaterial(@Param("material") Material material);

    // 根据物料id删除物料信息
    int deleteById(@Param("id") String id);
    // 动态修改物料信息
    int update(@Param("material") Material material);
    int updateNote(@Param("material") Material material);
    List<Material> selectByID(@Param("materialId") String searchValue);

    List<Material> selectByType(@Param("materialType") String searchValue);


}