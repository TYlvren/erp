package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.model.*;
import com.cskaoyan.erp.service.ErpService;
import com.cskaoyan.erp.util.DeviceUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
        return erpService.findDeviceByPage();
    }

    @RequestMapping("deviceList/get/{id}")
    @ResponseBody
    public Device getDevice(@PathVariable("id")String id) {
        return erpService.findServiceDeviceById(id);
    }

    @RequestMapping("employee/get/{id}")
    @ResponseBody
    public Employee getEmploy(@PathVariable("id")String id) {
        return erpService.findEmployeeById(id);
    }

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
    public @ResponseBody Map<String, Object> findAllDeviceByPageData(int page, int rows) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceByPage());
    }

    @RequestMapping("deviceList/add_judge")
    public String add1Device() {
        return "deviceList_add";
    }

    @RequestMapping("deviceList/add")
    public String add2Device() {
        return "deviceList_add";
    }

    @RequestMapping(value = "deviceList/insert")
    public @ResponseBody Map<String, String> insertDevice(Device device) {
        int i = erpService.insertDevice(device);
        return DeviceUtils.returnStatus(i);
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
        int i = erpService.updateDevice(device);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceList/update_note")
    public @ResponseBody Map<String, String> updateDeviceNote(Device device) {
        int i = erpService.updateDeviceNote(device);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping(value = "deviceList/update_all")
    public @ResponseBody Map<String, String> updateAllDevice(Device device) {
        int i = erpService.updateDevice(device);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceList/delete_judge")
    public String delete1Device() {
        return "deviceList";
    }

    @RequestMapping("deviceList/delete_batch")
    public @ResponseBody Map<String, String> deleteDevice(String ids) {
        String[] split = ids.split(",");
        int i = 0;
        for (String id : split) {
            i = erpService.deleteDevice(id);
        }
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceList/search_device_by_deviceId")
    public @ResponseBody Map<String, Object> searchDeviceById(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceById(searchValue));
    }

    @RequestMapping("deviceList/search_device_by_deviceName")
    public @ResponseBody Map<String, Object> searchDeviceByName(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceByName(searchValue));
    }

    @RequestMapping("deviceList/search_device_by_deviceTypeName")
    public @ResponseBody Map<String, Object> searchDeviceByTypeName(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceByTypeName(searchValue));
    }




    /*---------设备种类模块------------------------------------------------------------------------*/
    @RequestMapping("deviceType/update_all")
    public @ResponseBody Map<String, String> updateAllDeviceType(DeviceType deviceType) {
        int i = erpService.updateDeviceType(deviceType);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceType/get/{id}")
    @ResponseBody
    public DeviceType getDeviceType(@PathVariable("id")String id) {
        return erpService.getDeviceTypeById(id);
    }

    @RequestMapping("deviceType/get_data")
    public @ResponseBody List<DeviceType> findAllDeviceType() {
        return erpService.findDeviceTypeByPage();
    }

    @RequestMapping("device/deviceType")
    public String findAllDeviceTypeByPage(HttpSession session) {
        List<String> list = new ArrayList();
        list.add("deviceType:add");
        list.add("deviceType:edit");
        list.add("deviceType:delete");
        session.setAttribute("sysPermissionList", list);
        return "deviceType";
    }

    @RequestMapping("/deviceType/list")
    public @ResponseBody Map<String, Object> findAllDeviceTypeByPageData(@RequestParam int page, int rows) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo( erpService.findDeviceTypeByPage());
    }

    @RequestMapping("deviceType/add_judge")
    public String add1DeviceType() {
        return "deviceType_add";
    }

    @RequestMapping("deviceType/add")
    public String add2DeviceType() {
        return "deviceType_add";
    }

    @RequestMapping("deviceType/insert")
    public @ResponseBody Map<String, String> insert(DeviceType deviceType) {
        int i = erpService.insertDeviceType(deviceType);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceType/edit_judge")
    public String edit1DeviceType() {
        return "deviceType_edit";
    }

    @RequestMapping("deviceType/edit")
    public String edit2DeviceType() {
        return "deviceType_edit";
    }

    @RequestMapping("deviceType/update")
    public @ResponseBody Map<String, String> update(DeviceType deviceType) {
        int i = erpService.updateDeviceType(deviceType);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceType/delete_judge")
    public String delete1DeviceType() {
        return "deviceType";
    }

    @RequestMapping("deviceType/delete_batch")
    public @ResponseBody Map<String, String> delete(String ids) {
        String[] split = ids.split(",");
        int i = 0;
        for (String id : split) {
             i = erpService.deleteDeviceType(id);
        }
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceType/search_deviceType_by_deviceTypeId")
    public @ResponseBody Map<String, Object> searchDeviceTypeByIdData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceTypeById(searchValue));
    }

    @RequestMapping("deviceType/search_deviceType_by_deviceTypeName")
    public @ResponseBody Map<String, Object> searchDeviceTypeByNameData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceTypeByName(searchValue));
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
        return DeviceUtils.returnPageInfo(erpService.findDeviceeCheckByPage());
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
        int i = erpService.insertDeviceCheck(deviceCheck);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceCheck/edit_judge")
    public String edit1DeviceCheck() {
        return "deviceCheck_edit";
    }

    @RequestMapping("deviceCheck/edit")
    public String edit2DeviceCheck() {
        return "deviceCheck_edit";
    }

    @RequestMapping("deviceCheck/update")
    public @ResponseBody Map<String, String> updateDeviceCheck(DeviceCheck deviceCheck) {
        int i = erpService.updateDeviceCheck(deviceCheck);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceCheck/delete_judge")
    public String delete1DeviceCheck() {
        return "deviceCheck";
    }

    @RequestMapping("deviceCheck/delete_batch")
    public @ResponseBody Map<String, String> deleteDeviceCheck(String ids) {
        String[] split = ids.split(",");
        int i = 0;
        for (String id : split) {
            i = erpService.deleteDeviceCheck(id);
        }
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceCheckId")
    public @ResponseBody Map<String, Object> searchDeviceCheckByIdData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceCheckById(searchValue));
    }

    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceName")
    public @ResponseBody Map<String, Object> searchDeviceCheckByNameData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceCheckByName(searchValue));
    }

    @RequestMapping("deviceCheck/update_note")
    public @ResponseBody Map<String, String> updateDeviceCheckNote(DeviceCheck deviceCheck) {
        int i = erpService.updateDeviceCheckNote(deviceCheck);
        return DeviceUtils.returnStatus(i);
    }


    /*---------设备故障模块------------------------------------------------------------------------*/
    @RequestMapping("deviceFault/update_all")
    public @ResponseBody Map<String, String> updateAllDeviceFault(DeviceFault deviceFault) {
        int i = erpService.updateDeviceFault(deviceFault);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceFault/get_data")
    public @ResponseBody List<DeviceFault> findAllDeviceFault() {
        return erpService.findAllDeviceFaultByPage();
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
        return DeviceUtils.returnPageInfo(erpService.findAllDeviceFaultByPage());
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
        int i = erpService.insertDeviceFault(deviceFault);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceFault/edit_judge")
    public String edit1DeviceFault() {
        return "deviceFault_edit";
    }

    @RequestMapping("deviceFault/edit")
    public String edit2DeviceFault() {
        return "deviceFault_edit";
    }

    @RequestMapping("deviceFault/update")
    public @ResponseBody Map<String, String> updateDeviceFault(DeviceFault deviceFault) {
        int i = erpService.updateDeviceFault(deviceFault);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceFault/delete_judge")
    public String delete1DeviceFault() {
        return "deviceFault";
    }

    @RequestMapping("deviceFault/delete_batch")
    public @ResponseBody Map<String, String> deleteDeviceFault(String ids) {
        String[] split = ids.split(",");
        int i = 0;
        for (String id : split) {
            i = erpService.deleteDeviceFault(id);
        }
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceFault/search_deviceFault_by_deviceFaultId")
    public @ResponseBody Map<String, Object> searchDeviceFaultByIdData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceFaultById(searchValue));
    }

    @RequestMapping("deviceFault/search_deviceFault_by_deviceName")
    public @ResponseBody Map<String, Object> searchDeviceFaultByNameData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceFaultByName(searchValue));
    }

    @RequestMapping("deviceFault/update_note")
    public @ResponseBody Map<String, String> updateDeviceFaultNote(DeviceFault deviceFault) {
        int i = erpService.updateDeviceFaultNote(deviceFault);
        return DeviceUtils.returnStatus(i);
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
        return DeviceUtils.returnPageInfo(erpService.findDeviceMaintainByPage());
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
        int i = erpService.insertDeviceMaintain(deviceMaintain);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceMaintain/edit_judge")
    public String edit1DeviceMaintain() {
        return "deviceMaintain_edit";
    }

    @RequestMapping("deviceMaintain/edit")
    public String edit2DeviceMaintain() {
        return "deviceMaintain_edit";
    }

    @RequestMapping("deviceMaintain/update")
    public @ResponseBody Map<String, String> updateDeviceMaintain(DeviceMaintain deviceMaintain) {
        int i = erpService.updateDeviceMaintain(deviceMaintain);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceMaintain/delete_judge")
    public String delete1DeviceMaintain() {
        return "deviceFault";
    }

    @RequestMapping("deviceMaintain/delete_batch")
    public @ResponseBody Map<String, String> deleteDeviceMaintain(String ids) {
        String[] split = ids.split(",");
        int i = 0;
        for (String id : split) {
            i = erpService.deleteDeviceMaintain(id);
        }
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceMaintainId")
    public @ResponseBody Map<String, Object> searchDeviceMaintainByIdData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceMaintainById(searchValue));
    }

    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceFaultId")
    public @ResponseBody Map<String, Object> searchDeviceMaintainByFaultIdData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceMaintainByFaultId(searchValue));
    }

    @RequestMapping("deviceMaintain/update_note")
    public @ResponseBody Map<String, String> updateDeviceMaintainNote(DeviceMaintain deviceMaintain) {
        int i = erpService.updateDeviceMaintainNote(deviceMaintain);
        return DeviceUtils.returnStatus(i);
    }


}
