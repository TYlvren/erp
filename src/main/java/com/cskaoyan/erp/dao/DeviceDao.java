package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Device;
import com.cskaoyan.erp.model.DeviceType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceDao {

    List<Device> findAllDevice();

    int insertDevice(@Param("device") Device device);

    int updateDeviceById(@Param("device") Device device);

    int deleteDeviceById(@Param("id")String id);

    List<DeviceType> findDeviceById(@Param("id")String id);

    List<DeviceType> findDeviceByName(@Param("name")String name);

    int updateDeviceNote(@Param("device")Device device);

    List<DeviceType> findServiceDeviceById(@Param("id")String id);
}