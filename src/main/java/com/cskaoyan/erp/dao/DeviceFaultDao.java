package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.DeviceFault;

import java.util.List;

public interface DeviceFaultDao {

    List<DeviceFault> findAllDeviceFault();
}