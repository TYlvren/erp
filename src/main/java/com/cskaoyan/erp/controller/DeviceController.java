package com.cskaoyan.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Flying Elephant
 * Date 2019/4/3 0003 Time 16:39
 */
@Controller
@RequestMapping("device")
public class DeviceController {

    @RequestMapping("deviceList")
    public String findAllDeviceByPage() {
        System.out.println("deviceList来了");

        return "deviceList";
    }

    @RequestMapping("deviceType")
    public String findAllDeviceTypeByPage() {
        System.out.println("deviceType来了");

        return "deviceType";
    }

    @RequestMapping("deviceCheck")
    public String findAllDeviceCheckByPage() {
        System.out.println("deviceCheck来了");

        return "deviceCheck";
    }

    @RequestMapping("deviceFault")
    public String findAllDeviceFaultByPage() {
        System.out.println("deviceFault来了");

        return "deviceFault";
    }

    @RequestMapping("deviceMaintain")
    public String findAllDeviceMaintainByPage() {
        System.out.println("deviceMaintain来了");

        return "deviceMaintain";
    }

}
