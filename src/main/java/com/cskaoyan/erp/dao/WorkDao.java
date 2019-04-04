package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Product;
import com.cskaoyan.erp.model.Work;

import java.util.List;

public interface WorkDao {

    List<Work> selectAllWork();

    Work selectWorkById(String id);
}