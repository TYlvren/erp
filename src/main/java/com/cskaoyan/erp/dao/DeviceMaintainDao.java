package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.DeviceFault;
import com.cskaoyan.erp.model.DeviceMaintain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMaintainDao {

    List<DeviceMaintain> findAllDeviceMaintain();

    int insertDeviceMaintain(@Param("deviceMaintain") DeviceMaintain deviceMaintain);

    int updateDeviceMaintain(@Param("deviceMaintain")DeviceMaintain deviceMaintain);

    int deleteDeviceMaintain(@Param("id")String id);

    List<DeviceMaintain> findDeviceMaintainById(@Param("id")String searchValue);

    List<DeviceMaintain> findDeviceMaintainByFaultId(@Param("id")String searchValue);

    int updateDeviceMaintainNote(@Param("deviceMaintain")DeviceMaintain deviceMaintain);
}