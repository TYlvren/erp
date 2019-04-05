package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Manufacture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManufactureDao {

    List<Manufacture> selectAllManufacture();


    Manufacture selectManufactureById(String id);

    List<Manufacture> selectManufactureBySearch(@Param("condition") String condition,@Param("searchValue") String searchValue);
}