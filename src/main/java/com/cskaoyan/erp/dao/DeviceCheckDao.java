package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.DeviceCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceCheckDao {

    List<DeviceCheck> findAllDeviceCheck();

    int insertDeviceCheck(@Param("deviceCheck") DeviceCheck deviceCheck);

    int updateDeviceCheck(@Param("deviceCheck") DeviceCheck deviceCheck);
}