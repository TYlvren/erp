package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Device;

import java.util.List;

public interface DeviceDao {

    List<Device> findAllDevice();
}