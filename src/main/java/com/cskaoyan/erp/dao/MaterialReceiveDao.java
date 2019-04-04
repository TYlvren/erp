package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Material;
import com.cskaoyan.erp.model.MaterialReceive;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialReceiveDao {
    /*-------------物料收入模块------------------------------------------------*/
    List<MaterialReceive> selectMaterialReceive();
    int addMaterialReceive(@Param("materialReceive") Material material);

    int CountOfMaterialReceive();
}