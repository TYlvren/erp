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

    /**
     * 这是一个用来页面映射查找所有设备分类信息的方法
     * @param model
     * @param session
     * @return
     */
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

    /**
     * 这是一个显示所有设备种类类别并且分页的方法
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/deviceType/list")
    public @ResponseBody Map<String, Object> findAllDeviceTypeByPageData(@RequestParam int page, int rows) {
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

    /**
     * 对前端的请求进行映射，添加设备类别信息
     * @return
     */
    @RequestMapping("deviceType/add_judge")
    public String add1DeviceType() {
        return "deviceType_add";
    }
    /**
     * 对前端的请求进行映射，添加设备类别信息
     * @return
     */
    @RequestMapping("deviceType/add")
    public String add2DeviceType() {
        return "deviceType_add";
    }

    /**
     * 这是一个添加设备类别的方法
     * @param deviceType
     * @return 添加成功则返回200状态码，失败则返回提示信息，添加失败
     */
    @RequestMapping("deviceType/insert")
    public @ResponseBody Map<String, String> insert(DeviceType deviceType) {
        //System.out.println("iiiiiii");
        Map<String, String> map = new HashMap<>();
        int i = erpService.insertDeviceType(deviceType);
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "添加失败");
        }
        return map;
    }

    /**
     * 对前端的请求进行映射，修改设备类别信息
     * @return
     */
    @RequestMapping("deviceType/edit_judge")
    public String edit1DeviceType() {
        return "deviceType_edit";
    }
    /**
     * 对前端的请求进行映射，修改设备类别信息
     * @return
     */
    @RequestMapping("deviceType/edit")
    public String edit2DeviceType() {
        return "deviceType_edit";
    }

    /**
     * 这是一个修改设备类别的方法
     * @param deviceType
     * @return 修改成功则返回200状态码，失败则返回提示信息，修改失败
     */
    @RequestMapping("deviceType/update")
    public @ResponseBody Map<String, String> update(DeviceType deviceType) {
        //System.out.println(deviceType);
        Map<String, String> map = new HashMap<>();
        int i = erpService.updateDeviceType(deviceType);
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }

    /**
     * 对前端的请求进行映射，批量删除设备类别信息
     * @return
     */
    @RequestMapping("deviceType/delete_judge")
    public String delete1DeviceType() {
        //System.out.println("dddddddddddd");
        return "deviceType";
    }

    /**
     * 这是一个批量删除设备类别的方法
     * @param ids
     * @return 删除成功则返回200状态码，失败则返回提示信息，删除失败
     */
    @RequestMapping("deviceType/delete_batch")
    public @ResponseBody Map<String, String> delete(String ids) {
        //System.out.println(ids);
        Map<String, String> map = new HashMap<>();
        String[] split = ids.split(",");
        int i = 0;
        for (String id : split) {
             i = erpService.deleteDeviceType(id);
        }
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "删除失败");
        }
        return map;
    }

    /**
     * 这是一个设备分类根据id模糊搜索的方法
     * @param page
     * @param rows
     * @param searchValue
     * @return
     */
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeId")
    public @ResponseBody Map<String, Object> searchDeviceTypeByIdData(@RequestParam int page, int rows, String searchValue) {
        //System.out.println(page + "-------" + rows);
        PageHelper.startPage(page, rows, true);
        List<DeviceType> list = erpService.findDeviceTypeById(searchValue);
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        //System.out.println(pageInfo);
        return map;
    }

    /**
     * 这是一个设备分类根据id模糊搜索的方法
     * @param page
     * @param rows
     * @param searchValue
     * @return
     */
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeName")
    public @ResponseBody Map<String, Object> searchDeviceTypeByNameData(@RequestParam int page, int rows, String searchValue) {
        //System.out.println(page + "-------" + rows);
        PageHelper.startPage(page, rows, true);
        List<DeviceType> list = erpService.findDeviceTypeByName(searchValue);
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        //System.out.println(pageInfo);
        return map;
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
