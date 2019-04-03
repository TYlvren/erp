package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.DeviceMaintain;

import java.util.List;

public interface DeviceMaintainDao {

    List<DeviceMaintain> findAllDeviceMaintain();
}