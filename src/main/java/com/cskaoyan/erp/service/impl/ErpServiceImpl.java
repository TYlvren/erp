package com.cskaoyan.erp.service.impl;


import com.cskaoyan.erp.dao.*;
import com.cskaoyan.erp.model.*;

import com.cskaoyan.erp.dao.DeviceMaintainDao;
import com.cskaoyan.erp.dao.UnQualifyApplyDao;
import com.cskaoyan.erp.model.DeviceMaintain;
import com.cskaoyan.erp.model.UnQualifyApply;

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
    private DepartmentDao departmentDao;

    @Autowired
    private CustomDao customDao;

    @Autowired
    private ProductDao productDao;

    /**------------------------------order--------------------------------*/

    /**
     * 查询订单API的实现
     *
     * @return
     * @see { ErpService }
     */
    @Override
    public List<COrder> findCOrder() {
        return cOrderDao.selectALLCOder();
    }

    /**
     * ------------------------------custom--------------------------------
     */
    @Override
    public List<Custom> findCustom() {
        return customDao.selectAllCustom();
    }

    @Override
    public Custom findCustomById(String id) {
        return customDao.selectCustomById(id);
    }


    /**
     * ------------------------------product--------------------------------
     */
    @Override
    public List<Product> findProduct() {
        return productDao.selectAllProduct();
    }

    @Override
    public Product findProductByid(String id) {
        return productDao.selectProductById(id);
    }

    @Override
    public int addProduct(Product product) {
        return productDao.insertProduct(product);
    }

    /*****************设备管理接口实现*************************************/
    @Autowired
    DeviceMaintainDao deviceMaintainDao;
    @Autowired
    DeviceTypeDao deviceTypeDao;
    @Autowired
    DeviceFaultDao deviceFaultDao;
    @Autowired
    DeviceDao deviceDao;
    @Autowired
    DeviceCheckDao deviceCheckDao;

    /*-------------设备分类模块------------------------------------------------*/

    @Override
    public List<DeviceType> findDeviceTypeByPage() {
        return deviceTypeDao.findAllDeviceType();
    }

    @Override
    public int insertDeviceType(DeviceType deviceType) {
        return deviceTypeDao.insertDeviceType(deviceType);
    }




    /*-------------设备模块----------------------------------------------------*/
    @Override
    public List<Device> findDeviceByPage() {
        return deviceDao.findAllDevice();
    }

    /*-------------设备例检模块------------------------------------------------*/

    /*-------------设备故障模块------------------------------------------------*/
    @Override
    public List<DeviceFault> findAllDeviceFaultByPage() {
        return  deviceFaultDao.findAllDeviceFault();
    }
    /*-------------设备维修模块------------------------------------------------*/
    @Override
    public List<DeviceMaintain> findDeviceMaintainByPage() {
        return deviceMaintainDao.findAllDeviceMaintain();
    }


    /*****************工艺监控接口实现*************************************/


    /*****************物料监控接口实现*************************************/


    /*****************质量监控接口实现*************************************/
//    ------------------不合格品管理-------------------
        //**********注入Dao
    @Autowired
    private UnQualifyApplyDao unQualifyApplyDao;
        //***********查询不合格品
    @Override
    public List<UnQualifyApply> findUnqualifyList() {

        return unQualifyApplyDao.findUnqualifyListDao();
    }
        //************新建不合格品
    @Override
    public void addUnqualifyService(UnQualifyApply unQualifyApply) {
         unQualifyApplyDao.addUnqualifyDao(unQualifyApply);
        return ;
    }
        //***********修改不合格品

    @Override
    public int updateUnqualifyService(UnQualifyApply unQualifyApply) {
        return  unQualifyApplyDao.updateUnqualifyDao(unQualifyApply);
    }

    /*****************人员监控接口实现*************************************/
    @Override
    public  List<Department> selectDepartment(){
       return departmentDao.selectDepartment();
    }

    /*****************系统管理接口实现*************************************/


}
