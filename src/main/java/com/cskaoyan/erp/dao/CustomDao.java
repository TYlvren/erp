package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Custom;

import java.util.List;

public interface CustomDao {

    List<Custom> selectAllCustom();

    Custom selectCustomById(String id);

    int insertCustom(Custom custom);

    int updateCustom(Custom custom);

    int deleteCustomByIds(String[] ids);
}