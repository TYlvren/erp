package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.model.DeviceType;
import com.cskaoyan.erp.service.ErpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Flying Elephant
 * Date 2019/4/3 0003 Time 16:39
 */
@Controller
public class DeviceController {

    @Autowired
    ErpService erpService;

    /*---------设备模块------------------------------------------------------------------------*/
    @RequestMapping("device/deviceList")
    public String findAllDeviceByPage() {
        return "deviceList";
    }



    /*---------设备种类模块------------------------------------------------------------------------*/
    @RequestMapping("device/deviceType")
    public String findAllDeviceTypeByPage(Model model) {

        List<DeviceType> deviceTypeByPage = erpService.findDeviceTypeByPage();

        return "deviceType";
    }

    @RequestMapping("/deviceType/list")
    public @ResponseBody  List<DeviceType> findAllDeviceByPageData(@RequestParam(defaultValue = "1") int page, int rows) {
        /*System.out.println(page + "-------" + rows);
        PageHelper.startPage(page, rows);*/
        List<DeviceType> deviceTypeByPage = erpService.findDeviceTypeByPage();
       /* PageInfo pageInfo = new PageInfo(deviceTypeByPage);
        System.out.println(pageInfo);*/
        return deviceTypeByPage;
    }

    /*---------设备例检模块------------------------------------------------------------------------*/
    @RequestMapping("device/deviceCheck")
    public String findAllDeviceCheckByPage() {


        return "deviceCheck";
    }


    /*---------设备故障模块------------------------------------------------------------------------*/
    @RequestMapping("device/deviceFault")
    public String findAllDeviceFaultByPage() {


        return "deviceFault";
    }


    /*---------设备维修模块-----------------------------------------------------------------------*/
    @RequestMapping("device/deviceMaintain")
    public String findAllDeviceMaintainByPage() {


        return "deviceMaintain";
    }

}
