package com.cskaoyan.erp.service;

import com.cskaoyan.erp.model.*;



import com.cskaoyan.erp.model.DeviceMaintain;
import com.cskaoyan.erp.model.DeviceType;

import com.cskaoyan.erp.model.UnQualifyApply;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 生产管理平台Service层接口
 * @version V1.0
 */
@Service("erpService")
public interface ErpService {

    /*****************计划进度接口实现*************************************/


    /**------------------------------Order----------------------------------*/
    List<COrder> findCOrder();

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
    /*-------------设备例检模块------------------------------------------------*/

    /*-------------设备故障模块------------------------------------------------*/
    List<DeviceFault> findAllDeviceFaultByPage();
    /*-------------设备维修模块------------------------------------------------*/
    List<DeviceMaintain> findDeviceMaintainByPage();

    /*****************工艺监控接口实现*************************************/


    /*****************物料监控接口实现*************************************/
    /**
     * 获得所有物料信息
     * @return Material对象的List集合
     * */
    List<Material> selectMaterial();
    int selectCountOfMaterial();

    /**
     * 根据material_id删除物料信息
     * @param id
     * */
    int removeMaterialById(String id);

    /**
     * 修改物料信息
     * @param material 物料对象
     * */
    int modifyMaterial(Material material);

    /**
     * 添加物料信息
     *
     * @param material 物料对象
     */
    int addMaterial(Material material) ;
    Material findMaterialById(String id);


    /*****************质量监控接口实现*************************************/
    List<UnQualifyApply> findUnqualifyList();
    void  addUnqualifyService(UnQualifyApply unQualifyApply);
    int updateUnqualifyService(UnQualifyApply unQualifyApply);
    int deleteUnqualifyService(String[] ids);
    int updateNoteUnqualifyService(String unqualifyApplyId,String note);



    /*****************人员监控接口实现*************************************/
    List<Department> selectDepartment();

    List<Work> findWork();


    /*****************系统管理接口实现*************************************/

}
