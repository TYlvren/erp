package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Device;
import com.cskaoyan.erp.model.DeviceCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceCheckDao {

    List<DeviceCheck> findAllDeviceCheck();

    int insertDeviceCheck(@Param("deviceCheck") DeviceCheck deviceCheck);

    int updateDeviceCheck(@Param("deviceCheck") DeviceCheck deviceCheck);

    int deleteDeviceCheck(@Param("id")String id);

    List<DeviceCheck> findDeviceCheckById(@Param("id") String id);

    DeviceCheck getDeviceCheckById(@Param("id") String id);

    List<DeviceCheck> getDeviceCheckByName(@Param("name")String searchValue);

    int updateDeviceCheckByNote(@Param("deviceCheck")DeviceCheck deviceCheck);
}