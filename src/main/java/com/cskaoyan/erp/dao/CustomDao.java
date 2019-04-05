package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.COrder;
import com.cskaoyan.erp.model.Custom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomDao {

    List<Custom> selectAllCustom();

    Custom selectCustomById(String id);

    int insertCustom(Custom custom);

    int updateCustom(Custom custom);

    int deleteCustomByIds(String[] ids);

    List<COrder> selectCustomBySearch(@Param("condition") String condition,@Param("searchValue") String searchValue);
}