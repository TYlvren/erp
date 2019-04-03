package com.cskaoyan.erp.service;

import com.cskaoyan.erp.model.COrder;

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


    /**
     * 查询订单API
     * @return
     */
    List<COrder> findCOrder();


    /*****************设备管理接口实现*************************************/
    List<DeviceType> findDeviceTypeByPage();

    /*****************工艺监控接口实现*************************************/


    /*****************物料监控接口实现*************************************/


    /*****************质量监控接口实现*************************************/
    List<UnQualifyApply> findUnqualifyList();
    void  addUnqualifyService(UnQualifyApply unQualifyApply);

    /*****************人员监控接口实现*************************************/




    /*****************系统管理接口实现*************************************/

}
