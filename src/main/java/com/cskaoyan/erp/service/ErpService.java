package com.cskaoyan.erp.service;

import com.cskaoyan.erp.model.*;



import com.cskaoyan.erp.model.DeviceMaintain;
import com.cskaoyan.erp.model.DeviceType;

import com.cskaoyan.erp.model.UnQualifyApply;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: 生产管理平台Service层接口
 * @version V1.0
 */
@Service("erpService")
public interface ErpService {

    /*****************计划进度接口实现*************************************/


    /**------------------------------Order----------------------------------*/
    /**
     * 查找所有的COrder
     * @return
     */
    List<COrder> findCOrder();

    /**
     * 模糊查找
     * @param condition
     * @param searchValue
     * @return
     */
    List<COrder> findCOrderBySearch(String condition, String searchValue);
    /**
     * 通过id 查找COrder
     * @param id
     * @return
     */
    COrder findCOrderById(String id);

    int addOrder(COrder cOrder);

    int editOrder(COrder cOrder);

    int deleteOrder(String[] ids);

    /**------------------------------Custom--------------------------------*/
    List<Custom> findCustom();
    Custom findCustomById(String id);

    int addCustom(Custom custom);

    int editCustom(Custom custom);

    int deleteCustom(String[] ids);

    /**------------------------------Product--------------------------------*/
    List<Product> findProduct();
    Product findProductById(String id);
    int addProduct(Product product);
    int editProduct(Product product);
    int deleteProduct(String[] ids);


    /**------------------------------Manufacture--------------------------------*/
    List<Manufacture> findManufacture();
    Manufacture findManufactureById(String id);

    /**------------------------------Work--------------------------------*/
    List<Work> findWork();
    Work findWorkById(String id);
    int addWork(Work work);

    int editWork(Work work);

    int deleteWork(String[] ids);
    /**------------------------------Task--------------------------------*/
    List<Task> findTask();

    Task findTaskById(String id);

    int addTask(Task task);

    int editTask(Task task);

    int deleteTask(String[] ids);

    /*****************设备管理接口实现*************************************/
    /*-------------设备分类模块------------------------------------------------*/
    List<DeviceType> findDeviceTypeByPage();
    int insertDeviceType(DeviceType deviceType);
    int updateDeviceType(DeviceType deviceType);
    int deleteDeviceType(String id);
    List<DeviceType> findDeviceTypeById(String searchValue);
    List<DeviceType> findDeviceTypeByName(String searchValue);
    /*-------------设备模块------------------------------------------------*/
    List<Device> findDeviceByPage();
    int insertDevice(Device device);
    int updateDevice(Device device);
    int deleteDevice(String id);
    List<Device> findDeviceById(String searchValue);
    Device findServiceDeviceById(String id);
    List<Device> findDeviceByName(String searchValue);
    int updateDeviceNote(Device device);
    /*-------------设备例检模块------------------------------------------------*/
    List<DeviceCheck> findDeviceeCheckByPage();
    int insertDeviceCheck(DeviceCheck deviceCheck);
    int updateDeviceCheck(DeviceCheck deviceCheck);
    int deleteDeviceCheck(String id);
    List<DeviceCheck> findDeviceCheckById(String searchValue);
    DeviceCheck getDeviceCheckById(String id);
    List<DeviceCheck> findDeviceCheckByName(String searchValue);
    int updateDeviceCheckNote(DeviceCheck deviceCheck);
    /*-------------设备故障模块------------------------------------------------*/
    List<DeviceFault> findAllDeviceFaultByPage();
    /*-------------设备维修模块------------------------------------------------*/
    List<DeviceMaintain> findDeviceMaintainByPage();

    /*****************工艺监控接口实现*************************************/


    /*****************物料监控接口实现*************************************/
    /*-------------物料信息模块------------------------------------------------*/
    List<Material> selectMaterial();
    int selectCountOfMaterial();
    int removeMaterialById(String id);
    int modifyMaterial(Material material);
    int addMaterial(Material material) ;
    List<Material> selectMaterialById(String searchValue);
    List<Material> selectMaterialByType(String searchValue);
    int modifyNote(Material material);
    /*-------------物料收入模块------------------------------------------------*/
    List<MaterialReceive> selectMaterialReceive();
    int selectCountOfMaterialReceive();
    int removeMaterialReceiveById(String id);
    int modifyMaterialReceive(MaterialReceive materialReceive);
    int addMaterialReceive(MaterialReceive materialReceive) ;
    List<Material> selectMaterialId();
    int modifyReceiveNote(MaterialReceive materialReceive);
    /*****************质量监控接口实现*************************************/
    //不合格品管理相关方法
    List<UnQualifyApply> findUnqualifyList();
    int  addUnqualifyService(UnQualifyApply unQualifyApply);
    int updateUnqualifyService(UnQualifyApply unQualifyApply);
    int deleteUnqualifyService(String[] ids);
    int updateNoteUnqualifyService(String unqualifyApplyId,String note);
    List<UnQualifyApply>searchUnqualifyService(String searchname,String searchValue);
    //成品计量质检模块相关方法
     List<FinalMeasureCheck>findFMeasureCheck();
    int  addFMeasureCheckService(FinalMeasureCheck finalMeasureCheck);
    int  updateFMeasureCheckService(FinalMeasureCheck finalMeasureCheck);
    int deleteFMeasureCheckService(String[] ids);
    int updateNoteFMeasureCheckService(String fMeasureCheckId,String note);
    List<FinalMeasureCheck> searchFMeasureCheckService(String searchname,String searchValue);
    //成品计数质检模块相关方法
    List<FinalCountCheck>findFCountCheck();
    int  addFCountCheckService(FinalCountCheck finalCountCheck);
    int  updateFCountCheckService(FinalCountCheck finalCountCheck);
    int deleteFCountCheckService(String[] ids);
    int updateNoteFCountCheckService(String fCountCheckId,String note);
    List<FinalCountCheck>searchFCountCheckService(String searchname,String searchValue);
    //工序计量质检模块相关方法
    List<ProcessMeasureCheck>findPMeasureCheck();
    int  addPMeasureCheckService(ProcessMeasureCheck processMeasureCheck);
    int  updatePMeasureCheckService(ProcessMeasureCheck processMeasureCheck);
    int deletePMeasureCheckService(String[] ids);
    int updateNotePMeasureCheckService(String pMeasureCheckId,String note);
    List<ProcessMeasureCheck>searchPMeasureCheckService(String searchname,String searchValue);
    //工序计数质检模块相关方法

    List<ProcessCountCheck>findPCountCheckService();
    int  addPCountCheckService(ProcessCountCheck processCountCheck);
    int  updatePCountCheckService(ProcessCountCheck processCountCheck);
    int deletePCountCheckService(String[] ids);
    int updateNotePCountCheckService(String pCountCheckId,String note);
    List<ProcessCountCheck>searchPCountCheckService(String searchname,String searchValue);
    /*****************人员监控接口实现*************************************/
    //部门管理模块
    List<Department> findDepartment();
    Department findDepartmentById(String id);
    int addDepartment( Department department);
    int editDepartment(Department department);
    int deleteDepartment(String[] ids);




    /*****************系统管理接口实现*************************************/

}
