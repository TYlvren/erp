package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.model.Device;
import com.cskaoyan.erp.model.DeviceFault;
import com.cskaoyan.erp.model.DeviceMaintain;
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

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/deviceList/list")
    public @ResponseBody   Map<String, Object> findAllDeviceByPageData(@RequestParam int page, int rows) {
        //System.out.println(page + "-------" + rows);
        PageHelper.startPage(page, rows, true);
        List<Device> list = erpService.findDeviceByPage();
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        //System.out.println(pageInfo);
        return map;
    }


    /*---------设备种类模块------------------------------------------------------------------------*/
    @RequestMapping("device/deviceType")
    public String findAllDeviceTypeByPage(Model model, HttpSession session) {
        List<String> list = new ArrayList();
        list.add("deviceType:add");
        list.add("deviceType:edit");
        list.add("deviceType:delete");
        session.setAttribute("sysPermissionList", list);
        List<DeviceType> deviceTypeByPage = erpService.findDeviceTypeByPage();
        return "deviceType";
    }

    @RequestMapping("/deviceType/list")
    public @ResponseBody   Map<String, Object> findAllDeviceTypeByPageData(@RequestParam int page, int rows) {
        //System.out.println(page + "-------" + rows);
        PageHelper.startPage(page, rows, true);
        List<DeviceType> list = erpService.findDeviceTypeByPage();
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        //System.out.println(pageInfo);
        return map;
    }

    @RequestMapping("deviceType/add_judge")
    public String add1DeviceType() {
        return "deviceType";
    }

    @RequestMapping("deviceType/add")
    public String add2DeviceType() {
        return "deviceType_add";
    }

    @RequestMapping("deviceType/insert")
    public String insert(DeviceType deviceType) {
        System.out.println("iiiiiii");
        erpService.insertDeviceType(deviceType);
        return "deviceType";
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

    @RequestMapping("/deviceFault/list")
    public @ResponseBody Map<String, Object> findAllDeviceFaultByPageData(@RequestParam int page, int rows) {
        PageHelper.startPage(page, rows, true);
        List<DeviceFault> list = erpService.findAllDeviceFaultByPage();
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }



    /*---------设备维修模块-----------------------------------------------------------------------*/
    @RequestMapping("device/deviceMaintain")
    public String findAllDeviceMaintainByPage() {
        return "deviceMaintain";
    }

    @RequestMapping("/deviceMaintain/list")
    public @ResponseBody Map<String, Object> findAllDeviceMaintainByPageData(@RequestParam int page, int rows) {
        PageHelper.startPage(page, rows, true);
        List<DeviceMaintain> list = erpService.findDeviceMaintainByPage();
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

}
