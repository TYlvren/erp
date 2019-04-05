package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.DeviceFault;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceFaultDao {

    List<DeviceFault> findAllDeviceFault();

    int insertDeviceFault(@Param("deviceFault") DeviceFault deviceFault);

    int updateDeviceFault(@Param("deviceFault")DeviceFault deviceFault);

    int deleteDeviceFault(@Param("id")String id);

    List<DeviceFault> findDeviceFaultById(@Param("id")String searchValue);

    DeviceFault getDeviceFaultById(@Param("id")String searchValue);

    List<DeviceFault> findDeviceFaultByName(@Param("name")String searchValue);

    int updateDeviceFaultNote(@Param("deviceFault")DeviceFault deviceFault);
}