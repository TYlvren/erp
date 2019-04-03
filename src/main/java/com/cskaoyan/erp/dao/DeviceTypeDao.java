package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.DeviceType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceTypeDao {

    List<DeviceType> findAllDeviceType();

    int modifyDeviceTypeById(DeviceType deviceType);

    int insertDeviceType(@Param("deviceType") DeviceType deviceType);
}