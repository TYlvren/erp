package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.model.*;
import com.cskaoyan.erp.service.ErpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("deviceList/get_data")
    public @ResponseBody List<Device> findAllDevice() {
        List<Device> deviceByPage = erpService.findDeviceByPage();
        return deviceByPage;
    }

    @RequestMapping("deviceList/get/{id}")
    @ResponseBody
    public Device getDevice(@PathVariable("id")String id) {
        return erpService.findServiceDeviceById(id);
    }

    /*@RequestMapping("employee/get/{id}")
    @ResponseBody
    public Device getEmploy(@PathVariable("id")String id) {
        return erpService.findServiceDeviceById(id);
    }*/

    /*@RequestMapping("order/get/{id}")
    @ResponseBody
    public Employee getOrder(@PathVariable("id") String id) {
        return erpService.;
    }*/

    @RequestMapping("device/deviceList")
    public String findAllDeviceByPage(HttpSession session) {
        List<String> list = new ArrayList();
        list.add("device:add");
        list.add("device:edit");
        list.add("device:delete");
        session.setAttribute("sysPermissionList", list);
        return "deviceList";
    }

    @RequestMapping("/deviceList/list")
    public @ResponseBody   Map<String, Object> findAllDeviceByPageData(@RequestParam int page, int rows) {
        PageHelper.startPage(page, rows, true);

        List<Device> list = erpService.findDeviceByPage();

        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    /**
     * 对前端的请求进行映射，添加设备信息
     * @return
     */
    @RequestMapping("deviceList/add_judge")
    public String add1Device() {
        return "deviceList_add";
    }

    @RequestMapping("deviceList/add")
    public String add2Device() {
        return "deviceList_add";
    }

    /**
     * 这是一个添加设备的方法
     * @param device
     * @return 添加成功则返回200状态码，失败则返回提示信息，添加失败
     */
    @RequestMapping("deviceList/insert")
    public @ResponseBody Map<String, String> insertDevice(Device device) {
        System.out.println(device);
        Map<String, String> map = new HashMap<>();
        int i = erpService.insertDevice(device);
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "添加失败");
        }
        return map;
    }

    @RequestMapping("deviceList/edit_judge")
    public String edit1Device() {
        return "deviceList_add";
    }

    @RequestMapping("deviceList/edit")
    public String edit2Device() {
        return "deviceList_add";
    }

    @RequestMapping("deviceList/update")
    public @ResponseBody Map<String, String> updateDevice(Device device) {

        Map<String, String> map = new HashMap<>();
        int i = erpService.updateDevice(device);
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }

    @RequestMapping("deviceList/update_note")
    public @ResponseBody Map<String, String> updateDeviceNote(Device device) {
        Map<String, String> map = new HashMap<>();
        int i = erpService.updateDeviceNote(device);
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }

    @RequestMapping("deviceList/delete_judge")
    public String delete1Device() {
        //System.out.println("dddddddddddd");
        return "deviceList";
    }

    @RequestMapping("deviceList/delete_batch")
    public @ResponseBody Map<String, String> deleteDevice(String ids) {
        //System.out.println(ids);
        Map<String, String> map = new HashMap<>();
        String[] split = ids.split(",");
        int i = 0;
        for (String id : split) {
            i = erpService.deleteDevice(id);
        }
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "删除失败");
        }
        return map;
    }

    @RequestMapping("deviceList/search_device_by_deviceId")
    public @ResponseBody Map<String, Object> searchDeviceById(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        List<Device> list = erpService.findDeviceById(searchValue);
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @RequestMapping("deviceList/search_device_by_deviceName")
    public @ResponseBody Map<String, Object> searchDeviceByName(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        List<Device> list = erpService.findDeviceByName(searchValue);
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
    @RequestMapping("deviceList/search_device_by_deviceTypeName")
    public @ResponseBody Map<String, Object> searchDeviceByTypeName(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        List<Device> list = erpService.findDeviceByTypeName(searchValue);
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }




    /*---------设备种类模块------------------------------------------------------------------------*/
    @RequestMapping("deviceType/update_all")
    public @ResponseBody Map<String, String> updateAllDeviceType(DeviceType deviceType) {
        Map<String, String> map = new HashMap<>();
        int i = erpService.updateDeviceType(deviceType);
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }

    @RequestMapping("deviceType/get/{id}")
    @ResponseBody
    public DeviceType getDeviceType(@PathVariable("id")String id) {
        return erpService.getDeviceTypeById(id);
    }

    @RequestMapping("deviceType/get_data")
    public @ResponseBody List<DeviceType> findAllDeviceType() {
        List<DeviceType> deviceTypeByPage = erpService.findDeviceTypeByPage();
        return deviceTypeByPage;
    }

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
        //List<DeviceType> deviceTypeByPage = erpService.findDeviceTypeByPage();
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
     * 这是一个设备分类根据Name模糊搜索的方法
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
    public String findAllDeviceCheckByPage(HttpSession session) {
        List<String> list = new ArrayList();
        list.add("deviceCheck:add");
        list.add("deviceCheck:edit");
        list.add("deviceCheck:delete");
        session.setAttribute("sysPermissionList", list);
        return "deviceCheck";
    }

    @RequestMapping("/deviceCheck/list")
    public @ResponseBody Map<String, Object> findAllDeviceCheckByPageData(int page, int rows) {
        PageHelper.startPage(page, rows, true);
        List<DeviceCheck> list = erpService.findDeviceeCheckByPage();
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @RequestMapping("deviceCheck/add_judge")
    public String add1DeviceCheck() {
        return "deviceCheck_add";
    }

    @RequestMapping("deviceCheck/add")
    public String add2DeviceCheck() {
        return "deviceCheck_add";
    }

    @RequestMapping("deviceCheck/insert")
    public @ResponseBody Map<String, String> insertDeviceCheck(DeviceCheck deviceCheck) {
        Map<String, String> map = new HashMap<>();
        int i = erpService.insertDeviceCheck(deviceCheck);
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "添加失败");
        }
        return map;
    }

    @RequestMapping("deviceCheck/edit_judge")
    public String edit1DeviceCheck() {
        return "deviceCheck_edit";
    }
    /**
     * 对前端的请求进行映射，修改设备类别信息
     * @return
     */
    @RequestMapping("deviceCheck/edit")
    public String edit2DeviceCheck() {
        return "deviceCheck_edit";
    }

    @RequestMapping("deviceCheck/update")
    public @ResponseBody Map<String, String> updateDeviceCheck(DeviceCheck deviceCheck) {
        Map<String, String> map = new HashMap<>();
        int i = erpService.updateDeviceCheck(deviceCheck);
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }

    @RequestMapping("deviceCheck/delete_judge")
    public String delete1DeviceCheck() {
        return "deviceCheck";
    }

    @RequestMapping("deviceCheck/delete_batch")
    public @ResponseBody Map<String, String> deleteDeviceCheck(String ids) {
        Map<String, String> map = new HashMap<>();
        String[] split = ids.split(",");
        int i = 0;
        for (String id : split) {
            i = erpService.deleteDeviceCheck(id);
        }
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "删除失败");
        }
        return map;
    }

    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceCheckId")
    public @ResponseBody Map<String, Object> searchDeviceCheckByIdData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        List<DeviceCheck> list = erpService.findDeviceCheckById(searchValue);
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceName")
    public @ResponseBody Map<String, Object> searchDeviceCheckByNameData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        List<DeviceCheck> list = erpService.findDeviceCheckByName(searchValue);
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @RequestMapping("deviceCheck/update_note")
    public @ResponseBody Map<String, String> updateDeviceCheckNote(DeviceCheck deviceCheck) {
        Map<String, String> map = new HashMap<>();
        int i = erpService.updateDeviceCheckNote(deviceCheck);
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }


    /*---------设备故障模块------------------------------------------------------------------------*/
    @RequestMapping("deviceFault/update_all")
    public @ResponseBody Map<String, String> updateAllDeviceFault(DeviceFault deviceFault) {
        Map<String, String> map = new HashMap<>();
        int i = erpService.updateDeviceFault(deviceFault);
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }

    @RequestMapping("deviceFault/get/{id}")
    @ResponseBody
    public DeviceFault getDeviceFault(@PathVariable("id")String id) {
        return erpService.getDeviceFaultById(id);
    }

    @RequestMapping("device/deviceFault")
    public String findAllDeviceFaultByPage(HttpSession session) {
        List<String> list = new ArrayList();
        list.add("deviceFault:add");
        list.add("deviceFault:edit");
        list.add("deviceFault:delete");
        session.setAttribute("sysPermissionList", list);
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

    @RequestMapping("deviceFault/add_judge")
    public String add1DeviceFault() {
        return "deviceFault_add";
    }

    @RequestMapping("deviceFault/add")
    public String add2DeviceFault() {
        return "deviceFault_add";
    }

    @RequestMapping("deviceFault/insert")
    public @ResponseBody Map<String, String> insertDeviceFault(DeviceFault deviceFault) {
        Map<String, String> map = new HashMap<>();
        int i = erpService.insertDeviceFault(deviceFault);
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "添加失败");
        }
        return map;
    }

    @RequestMapping("deviceFault/edit_judge")
    public String edit1DeviceFault() {
        return "deviceFault_edit";
    }
    /**
     * 对前端的请求进行映射，修改设备类别信息
     * @return
     */
    @RequestMapping("deviceFault/edit")
    public String edit2DeviceFault() {
        return "deviceFault_edit";
    }

    @RequestMapping("deviceFault/update")
    public @ResponseBody Map<String, String> updateDeviceFault(DeviceFault deviceFault) {
        Map<String, String> map = new HashMap<>();
        int i = erpService.updateDeviceFault(deviceFault);
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }

    @RequestMapping("deviceFault/delete_judge")
    public String delete1DeviceFault() {
        return "deviceFault";
    }

    @RequestMapping("deviceFault/delete_batch")
    public @ResponseBody Map<String, String> deleteDeviceFault(String ids) {
        Map<String, String> map = new HashMap<>();
        String[] split = ids.split(",");
        int i = 0;
        for (String id : split) {
            i = erpService.deleteDeviceFault(id);
        }
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "删除失败");
        }
        return map;
    }

    @RequestMapping("deviceFault/search_deviceFault_by_deviceFaultId")
    public @ResponseBody Map<String, Object> searchDeviceFaultByIdData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        List<DeviceFault> list = erpService.findDeviceFaultById(searchValue);
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @RequestMapping("deviceFault/search_deviceFault_by_deviceName")
    public @ResponseBody Map<String, Object> searchDeviceFaultByNameData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        List<DeviceFault> list = erpService.findDeviceFaultByName(searchValue);
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @RequestMapping("deviceFault/update_note")
    public @ResponseBody Map<String, String> updateDeviceFaultNote(DeviceFault deviceFault) {
        Map<String, String> map = new HashMap<>();
        int i = erpService.updateDeviceFaultNote(deviceFault);
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }








    /*---------设备维修模块-----------------------------------------------------------------------*/
    @RequestMapping("device/deviceMaintain")
    public String findAllDeviceMaintainByPage(HttpSession session) {
        List<String> list = new ArrayList();
        list.add("deviceMaintain:add");
        list.add("deviceMaintain:edit");
        list.add("deviceMaintain:delete");
        session.setAttribute("sysPermissionList", list);
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

    @RequestMapping("deviceMaintain/add_judge")
    public String add1DeviceMaintain() {
        return "deviceMaintain_add";
    }

    @RequestMapping("deviceMaintain/add")
    public String add2DeviceMaintain() {
        return "deviceMaintain_add";
    }

    @RequestMapping("deviceMaintain/insert")
    public @ResponseBody Map<String, String> insertDeviceMaintain(DeviceMaintain deviceMaintain) {
        Map<String, String> map = new HashMap<>();
        int i = erpService.insertDeviceMaintain(deviceMaintain);
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "添加失败");
        }
        return map;
    }

    @RequestMapping("deviceMaintain/edit_judge")
    public String edit1DeviceMaintain() {
        return "deviceMaintain_edit";
    }
    /**
     * 对前端的请求进行映射，修改设备类别信息
     * @return
     */
    @RequestMapping("deviceMaintain/edit")
    public String edit2DeviceMaintain() {
        return "deviceMaintain_edit";
    }

    @RequestMapping("deviceMaintain/update")
    public @ResponseBody Map<String, String> updateDeviceMaintain(DeviceMaintain deviceMaintain) {
        Map<String, String> map = new HashMap<>();
        int i = erpService.updateDeviceMaintain(deviceMaintain);
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }

    @RequestMapping("deviceMaintain/delete_judge")
    public String delete1DeviceMaintain() {
        return "deviceFault";
    }

    @RequestMapping("deviceMaintain/delete_batch")
    public @ResponseBody Map<String, String> deleteDeviceMaintain(String ids) {
        Map<String, String> map = new HashMap<>();
        String[] split = ids.split(",");
        int i = 0;
        for (String id : split) {
            i = erpService.deleteDeviceMaintain(id);
        }
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "删除失败");
        }
        return map;
    }

    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceMaintainId")
    public @ResponseBody Map<String, Object> searchDeviceMaintainByIdData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        List<DeviceMaintain> list = erpService.findDeviceMaintainById(searchValue);
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceFaultId")
    public @ResponseBody Map<String, Object> searchDeviceMaintainByFaultIdData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        List<DeviceMaintain> list = erpService.findDeviceMaintainByFaultId(searchValue);
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @RequestMapping("deviceMaintain/update_note")
    public @ResponseBody Map<String, String> updateDeviceMaintainNote(DeviceMaintain deviceMaintain) {
        Map<String, String> map = new HashMap<>();
        int i = erpService.updateDeviceMaintainNote(deviceMaintain);
        if (i > 0) {
            map.put("status", "200");
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }

    /*---------通用代码-----------------------------------------------------------------------*/
    /*public static void authorityUtils(HttpSession session) {
        List<String> list = new ArrayList();
        list.add("deviceType:add");
        list.add("deviceType:edit");
        list.add("deviceType:delete");
        session.setAttribute("sysPermissionList", list);
    }*/

}
