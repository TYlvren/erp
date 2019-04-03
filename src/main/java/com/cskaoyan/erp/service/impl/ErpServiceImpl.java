package com.cskaoyan.erp.service.impl;


import com.cskaoyan.erp.dao.*;
import com.cskaoyan.erp.model.*;
import com.cskaoyan.erp.service.ErpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("erpService")
public class ErpServiceImpl implements ErpService {


    /*****************计划进度接口实现*************************************/
    @Autowired
    private COrderDao cOrderDao;


    @Autowired
    private CustomDao customDao;

    @Autowired
    private ProductDao productDao;


    /**
     * 查询订单API的实现
     * @see { ErpService }
     * @return
     */
    @Override
    public List<COrder> findCOrder() {
        return cOrderDao.selectALLCOder();
    }

    @Override
    public List<Custom> findCustom(){
        return customDao.selectAllCustom();
    }

    @Override
    public List<Product> findProduct() {
        return productDao.selectAllProduct();
    }

    /*****************设备管理接口实现*************************************/
    @Autowired

    private DeviceTypeDao deviceTypeDao;
    @Override
    public List<DeviceType> findDeviceTypeByPage() {
        return  deviceTypeDao.findAllDeviceType();
    }

    /*****************工艺监控接口实现*************************************/


    /*****************物料监控接口实现*************************************/


    /*****************质量监控接口实现*************************************/
    @Autowired
    private UnQualifyApplyDao  unQualifyApplyDao;
    @Override
    public List<UnQualifyApply> findUnqualifyList() {

        return unQualifyApplyDao.findUnqualifyListDao();
    }

    /*****************人员监控接口实现*************************************/




    /*****************系统管理接口实现*************************************/


}
