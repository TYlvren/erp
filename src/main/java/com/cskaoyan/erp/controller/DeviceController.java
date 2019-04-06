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

    /**
     * 这是一个回显设备台账信息下拉框的方法
     * @return
     */
    @RequestMapping("deviceList/get_data")
    public @ResponseBody List<Device> findAllDevice() {
        return erpService.findDeviceByPage();
    }

    /**
     * 这是一个根据id查找一条设备信息的方法
     * @param id 修改设备信息的id
     * @return 返回回显的设备信息
     */
    @RequestMapping("deviceList/get/{id}")
    @ResponseBody
    public Device getDevice(@PathVariable("id")String id) {
        return erpService.findServiceDeviceById(id);
    }

    /**
     * 这是一个回显员工信息的方法
     */
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

    /**
     * 这是一个能够显示增删改按钮方法
     */
    @RequestMapping("device/deviceList")
    public String findAllDeviceByPage(HttpSession session) {
        List<String> list = new ArrayList();
        list.add("device:add");
        list.add("device:edit");
        list.add("device:delete");
        session.setAttribute("sysPermissionList", list);
        return "deviceList";
    }

    /**
     * 这是一个分页查找所有设备台账信息的方法
     */
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

    /**
     * 这是一个添加设备台账的方法
     */
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

    /**
     * 这是一个修改设备台账的方法
     */
    @RequestMapping("deviceList/update")
    public @ResponseBody Map<String, String> updateDevice(Device device) {
        int i = erpService.updateDevice(device);
        return DeviceUtils.returnStatus(i);
    }

    /**
     * 这是一个修改设备台账的备注的方法
     */
    @RequestMapping("deviceList/update_note")
    public @ResponseBody Map<String, String> updateDeviceNote(Device device) {
        int i = erpService.updateDeviceNote(device);
        return DeviceUtils.returnStatus(i);
    }

    /**
     * 这是一个其他模块修改设备台账的方法
     */
    @RequestMapping(value = "deviceList/update_all")
    public @ResponseBody Map<String, String> updateAllDevice(Device device) {
        int i = erpService.updateDevice(device);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceList/delete_judge")
    public String delete1Device() {
        return "deviceList";
    }

    /**
     * 这是一个批量删除设备台账的方法
     */
    @RequestMapping("deviceList/delete_batch")
    public @ResponseBody Map<String, String> deleteDevice(String ids) {
        String[] split = ids.split(",");
        int i = 0;
        for (String id : split) {
            i = erpService.deleteDevice(id);
        }
        return DeviceUtils.returnStatus(i);
    }

    /**
     * 这是一个用过设备id模糊搜索的方法
     */
    @RequestMapping("deviceList/search_device_by_deviceId")
    public @ResponseBody Map<String, Object> searchDeviceById(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceById(searchValue));
    }

    /**
     * 这是一个用过设备名称模糊搜索的方法
     */
    @RequestMapping("deviceList/search_device_by_deviceName")
    public @ResponseBody Map<String, Object> searchDeviceByName(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceByName(searchValue));
    }

    /**
     * 这是一个用过设备种类名称模糊搜索的方法
     */
    @RequestMapping("deviceList/search_device_by_deviceTypeName")
    public @ResponseBody Map<String, Object> searchDeviceByTypeName(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceByTypeName(searchValue));
    }




    /*---------设备种类模块------------------------------------------------------------------------*/
    /**
     * 这是一个其他模块修改设备种类信息的方法
     */
    @RequestMapping("deviceType/update_all")
    public @ResponseBody Map<String, String> updateAllDeviceType(DeviceType deviceType) {
        int i = erpService.updateDeviceType(deviceType);
        return DeviceUtils.returnStatus(i);
    }

    /**
     * 这是一个通过id回显设备种类信息的方法
     */
    @RequestMapping("deviceType/get/{id}")
    @ResponseBody
    public DeviceType getDeviceType(@PathVariable("id")String id) {
        return erpService.getDeviceTypeById(id);
    }

    /**
     * 这是一个通过id回显设备种类信息的方法
     */
    @RequestMapping("deviceType/get_data")
    public @ResponseBody List<DeviceType> findAllDeviceType() {
        return erpService.findDeviceTypeByPage();
    }

    /**
     * 这是显示增删改按钮的方法
     */
    @RequestMapping("device/deviceType")
    public String findAllDeviceTypeByPage(HttpSession session) {
        List<String> list = new ArrayList();
        list.add("deviceType:add");
        list.add("deviceType:edit");
        list.add("deviceType:delete");
        session.setAttribute("sysPermissionList", list);
        return "deviceType";
    }

    /**
     * 这是分页显示所有设备种类的方法
     */
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

    /**
     * 这是添加设备种类的方法
     */
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

    /**
     * 这是修改设备种类的方法
     */
    @RequestMapping("deviceType/update")
    public @ResponseBody Map<String, String> update(DeviceType deviceType) {
        int i = erpService.updateDeviceType(deviceType);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceType/delete_judge")
    public String delete1DeviceType() {
        return "deviceType";
    }

    /**
     * 这是删除设备种类的方法
     */
    @RequestMapping("deviceType/delete_batch")
    public @ResponseBody Map<String, String> delete(String ids) {
        String[] split = ids.split(",");
        int i = 0;
        for (String id : split) {
             i = erpService.deleteDeviceType(id);
        }
        return DeviceUtils.returnStatus(i);
    }

    /**
     * 这是一个通过设备种类id进行模糊搜索的方法
     */
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeId")
    public @ResponseBody Map<String, Object> searchDeviceTypeByIdData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceTypeById(searchValue));
    }

    /**
     * 这是一个通过设备种类名称进行模糊搜索的方法
     */
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeName")
    public @ResponseBody Map<String, Object> searchDeviceTypeByNameData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceTypeByName(searchValue));
    }








    /*---------设备例检模块------------------------------------------------------------------------*/
    /**
     * 这是一个显示增删改按钮的方法
     */
    @RequestMapping("device/deviceCheck")
    public String findAllDeviceCheckByPage(HttpSession session) {
        List<String> list = new ArrayList();
        list.add("deviceCheck:add");
        list.add("deviceCheck:edit");
        list.add("deviceCheck:delete");
        session.setAttribute("sysPermissionList", list);
        return "deviceCheck";
    }

    /**
     * 这是一个分页显示所有设备例检信息的方法
     */
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

    /**
     * 这是一个添加设备例检信息的方法
     */
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
    /**
     * 这是一个修改设备例检信息的方法
     */
    @RequestMapping("deviceCheck/update")
    public @ResponseBody Map<String, String> updateDeviceCheck(DeviceCheck deviceCheck) {
        int i = erpService.updateDeviceCheck(deviceCheck);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceCheck/delete_judge")
    public String delete1DeviceCheck() {
        return "deviceCheck";
    }

    /**
     * 这是一个批量删除设备例检信息的方法
     */
    @RequestMapping("deviceCheck/delete_batch")
    public @ResponseBody Map<String, String> deleteDeviceCheck(String ids) {
        String[] split = ids.split(",");
        int i = 0;
        for (String id : split) {
            i = erpService.deleteDeviceCheck(id);
        }
        return DeviceUtils.returnStatus(i);
    }

    /**
     * 这是一个通过设备例检id模糊搜索的方法
     */
    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceCheckId")
    public @ResponseBody Map<String, Object> searchDeviceCheckByIdData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceCheckById(searchValue));
    }

    /**
     * 这是一个通过设备例检名称模糊搜索的方法
     */
    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceName")
    public @ResponseBody Map<String, Object> searchDeviceCheckByNameData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceCheckByName(searchValue));
    }
    /**
     * 这是一个修改设备例检备注的方法
     */
    @RequestMapping("deviceCheck/update_note")
    public @ResponseBody Map<String, String> updateDeviceCheckNote(DeviceCheck deviceCheck) {
        int i = erpService.updateDeviceCheckNote(deviceCheck);
        return DeviceUtils.returnStatus(i);
    }


    /*---------设备故障模块------------------------------------------------------------------------*/
    /**
     * 这是一个其他模块修改设备故障的方法
     */
    @RequestMapping("deviceFault/update_all")
    public @ResponseBody Map<String, String> updateAllDeviceFault(DeviceFault deviceFault) {
        int i = erpService.updateDeviceFault(deviceFault);
        return DeviceUtils.returnStatus(i);
    }

    /**
     * 这是一个在添加信息时出现下拉框设备故障信息的方法
     */
    @RequestMapping("deviceFault/get_data")
    public @ResponseBody List<DeviceFault> findAllDeviceFault() {
        return erpService.findAllDeviceFaultByPage();
    }

    /**
     * 这是一个通过id找到设备故障信息并回显的方法
     */
    @RequestMapping("deviceFault/get/{id}")
    @ResponseBody
    public DeviceFault getDeviceFault(@PathVariable("id")String id) {
        return erpService.getDeviceFaultById(id);
    }

    /**
     * 这是一个显示增删改按钮的方法
     */
    @RequestMapping("device/deviceFault")
    public String findAllDeviceFaultByPage(HttpSession session) {
        List<String> list = new ArrayList();
        list.add("deviceFault:add");
        list.add("deviceFault:edit");
        list.add("deviceFault:delete");
        session.setAttribute("sysPermissionList", list);
        return "deviceFault";
    }

    /**
     * 这是一个分页显示设备故障的方法
     */
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

    /**
     * 这是一个增加设备故障信息的方法
     */
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

    /**
     * 这是一个修改设备故障信息的方法
     */
    @RequestMapping("deviceFault/update")
    public @ResponseBody Map<String, String> updateDeviceFault(DeviceFault deviceFault) {
        int i = erpService.updateDeviceFault(deviceFault);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceFault/delete_judge")
    public String delete1DeviceFault() {
        return "deviceFault";
    }

    /**
     * 这是一个批量删除设备故障信息的方法
     */
    @RequestMapping("deviceFault/delete_batch")
    public @ResponseBody Map<String, String> deleteDeviceFault(String ids) {
        String[] split = ids.split(",");
        int i = 0;
        for (String id : split) {
            i = erpService.deleteDeviceFault(id);
        }
        return DeviceUtils.returnStatus(i);
    }

    /**
     * 这是一个通过设备故障id模糊搜索的方法
     */
    @RequestMapping("deviceFault/search_deviceFault_by_deviceFaultId")
    public @ResponseBody Map<String, Object> searchDeviceFaultByIdData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceFaultById(searchValue));
    }

    /**
     * 这是一个通过设备故障名称模糊搜索的方法
     */
    @RequestMapping("deviceFault/search_deviceFault_by_deviceName")
    public @ResponseBody Map<String, Object> searchDeviceFaultByNameData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceFaultByName(searchValue));
    }

    /**
     * 这是一个其他模块修改设备故障信息的方法
     */
    @RequestMapping("deviceFault/update_note")
    public @ResponseBody Map<String, String> updateDeviceFaultNote(DeviceFault deviceFault) {
        int i = erpService.updateDeviceFaultNote(deviceFault);
        return DeviceUtils.returnStatus(i);
    }








    /*---------设备维修模块-----------------------------------------------------------------------*/
    /**
     * 这是一个显示增删改按钮的方法
     */
    @RequestMapping("device/deviceMaintain")
    public String findAllDeviceMaintainByPage(HttpSession session) {
        List<String> list = new ArrayList();
        list.add("deviceMaintain:add");
        list.add("deviceMaintain:edit");
        list.add("deviceMaintain:delete");
        session.setAttribute("sysPermissionList", list);
        return "deviceMaintain";
    }

    /**
     * 这是一个分页显示所有设备维修信息的方法
     */
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

    /**
     * 这是一个添加设备维修信息的方法
     */
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

    /**
     * 这是一个修改设备维修信息的方法
     */
    @RequestMapping("deviceMaintain/update")
    public @ResponseBody Map<String, String> updateDeviceMaintain(DeviceMaintain deviceMaintain) {
        int i = erpService.updateDeviceMaintain(deviceMaintain);
        return DeviceUtils.returnStatus(i);
    }

    @RequestMapping("deviceMaintain/delete_judge")
    public String delete1DeviceMaintain() {
        return "deviceFault";
    }

    /**
     * 这是一个批量删除设备维修信息的方法
     */
    @RequestMapping("deviceMaintain/delete_batch")
    public @ResponseBody Map<String, String> deleteDeviceMaintain(String ids) {
        String[] split = ids.split(",");
        int i = 0;
        for (String id : split) {
            i = erpService.deleteDeviceMaintain(id);
        }
        return DeviceUtils.returnStatus(i);
    }

    /**
     * 这是一个通过设备维修id模糊搜索的方法
     */
    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceMaintainId")
    public @ResponseBody Map<String, Object> searchDeviceMaintainByIdData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceMaintainById(searchValue));
    }

    /**
     * 这是一个通过设备故障id模糊搜索的方法
     */
    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceFaultId")
    public @ResponseBody Map<String, Object> searchDeviceMaintainByFaultIdData(@RequestParam int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows, true);
        return DeviceUtils.returnPageInfo(erpService.findDeviceMaintainByFaultId(searchValue));
    }

    /**
     * 这是一个修改设备故障备注的方法
     */
    @RequestMapping("deviceMaintain/update_note")
    public @ResponseBody Map<String, String> updateDeviceMaintainNote(DeviceMaintain deviceMaintain) {
        int i = erpService.updateDeviceMaintainNote(deviceMaintain);
        return DeviceUtils.returnStatus(i);
    }


}
