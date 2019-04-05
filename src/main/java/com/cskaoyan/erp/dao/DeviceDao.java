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

    List<Device> findDeviceById(@Param("id")String id);

    List<Device> findDeviceByName(@Param("name")String name);

    int updateDeviceNote(@Param("device")Device device);

    Device findServiceDeviceById(@Param("id")String id);

    List<Device> findDeviceByTypeName(@Param("name")String searchValue);
}