package com.cskaoyan.erp.service.impl;


import com.cskaoyan.erp.dao.DeviceMaintainDao;
import com.cskaoyan.erp.dao.UnQualifyApplyDao;
import com.cskaoyan.erp.model.DeviceMaintain;
import com.cskaoyan.erp.model.UnQualifyApply;
import com.cskaoyan.erp.service.ErpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.cskaoyan.erp.dao.COrderDao;
import com.cskaoyan.erp.dao.DeviceTypeDao;
import com.cskaoyan.erp.model.COrder;
import com.cskaoyan.erp.model.DeviceType;
import com.cskaoyan.erp.service.ErpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service("erpService")
public class ErpServiceImpl implements ErpService {


    /*****************计划进度接口实现*************************************/
    @Autowired
    private COrderDao cOrderDao;

    @Autowired
    private DeviceTypeDao deviceTypeDao;

    @Autowired
    DeviceMaintainDao deviceMaintainDao;


    private UnQualifyApplyDao  unQualifyApplyDao;

    /**
     * 查询订单API的实现
     * @see { ErpService }
     * @return
     */
    @Override
    public List<COrder> findCOrder() {
        return cOrderDao.selectALLCOder();
    }



    /*****************设备管理接口实现*************************************/

    /*-------------设备分类模块------------------------------------------------*/
    @Override
    public List<DeviceType> findDeviceTypeByPage() {
        return  deviceTypeDao.findAllDeviceType();
    }

    @Override
    public int insertDeviceType(DeviceType deviceType) {
        return deviceTypeDao.insertDeviceType(deviceType);
    }
    /*-------------设备模块----------------------------------------------------*/


    /*-------------设备例检模块------------------------------------------------*/

    /*-------------设备故障模块------------------------------------------------*/

    /*-------------设备维修模块------------------------------------------------*/
    @Override
    public List<DeviceMaintain> findDeviceMaintainByPage() {
        return deviceMaintainDao.findAllDeviceMaintain();
    }



    /*****************工艺监控接口实现*************************************/


    /*****************物料监控接口实现*************************************/


    /*****************质量监控接口实现*************************************/
    @Override
    public List<UnQualifyApply> findUnqualifyList() {

        return unQualifyApplyDao.findUnqualifyListDao();
    }

    /*****************人员监控接口实现*************************************/




    /*****************系统管理接口实现*************************************/


}
