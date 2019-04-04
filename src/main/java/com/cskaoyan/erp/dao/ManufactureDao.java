package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Manufacture;

import java.util.List;

public interface ManufactureDao {

    List<Manufacture> selectAllManufacture();
}