package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.DeviceType;

import java.util.List;

public interface DeviceTypeDao {

    List<DeviceType> findAllDeviceType();

    int modifyDeviceTypeById(DeviceType deviceType);

}