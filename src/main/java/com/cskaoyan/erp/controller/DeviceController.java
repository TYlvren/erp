package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.model.DeviceType;
import com.cskaoyan.erp.service.ErpService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Flying Elephant
 * Date 2019/4/3 0003 Time 16:39
 */
@Controller
@RequestMapping("device")
public class DeviceController {

    @Autowired
    ErpService erpService;

    /*---------设备模块------------------------------------------------------------------------*/
    @RequestMapping("deviceList")
    public String findAllDeviceByPage() {


        return "deviceList";
    }


    /*---------设备种类模块------------------------------------------------------------------------*/
    @RequestMapping("deviceType")
    public String findAllDeviceTypeByPage(Model model) {

        List<DeviceType> deviceTypeByPage = erpService.findDeviceTypeByPage();

        return "deviceType";
    }


    /*---------设备例检模块------------------------------------------------------------------------*/
    @RequestMapping("deviceCheck")
    public String findAllDeviceCheckByPage() {


        return "deviceCheck";
    }


    /*---------设备故障模块------------------------------------------------------------------------*/
    @RequestMapping("deviceFault")
    public String findAllDeviceFaultByPage() {


        return "deviceFault";
    }


    /*---------设备维修模块-----------------------------------------------------------------------*/
    @RequestMapping("deviceMaintain")
    public String findAllDeviceMaintainByPage() {


        return "deviceMaintain";
    }

}
