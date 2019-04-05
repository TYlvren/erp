package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.DeviceType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceTypeDao {

    List<DeviceType> findAllDeviceType();

    int modifyDeviceTypeById(@Param("deviceType")DeviceType deviceType);

    int insertDeviceType(@Param("deviceType") DeviceType deviceType);

    int deleteDeviceTypeById(String id);

    List<DeviceType> findDeviceTypeById(@Param("id")String searchValue);

    List<DeviceType> findDeviceTypeByName(@Param("name")String searchValue);

    DeviceType getDeviceTypeById(@Param("id")String id);
}