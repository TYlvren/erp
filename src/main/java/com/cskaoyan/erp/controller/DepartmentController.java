package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.model.Department;
import com.cskaoyan.erp.service.ErpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zi_an
 * Date 2019/4/3 time 23:07
 */
@Controller
public class DepartmentController {
 @Autowired
 private ErpService erpService;

 @RequestMapping("department/find")
 public String find(HttpSession httpSession) {
  List<String> sysPermissionList = (ArrayList<String>) httpSession.getAttribute("sysPermissionList");
  if (sysPermissionList == null) {
   sysPermissionList = new ArrayList<>();
  }
  if (!sysPermissionList.contains("department:add")) {
   sysPermissionList.add("department:add");
   sysPermissionList.add("department:edit");
   sysPermissionList.add("department:delete");
   httpSession.setAttribute("sysPermissionList", sysPermissionList);
  }
  return "department_list";
 }

 @RequestMapping("department/get/{id}")
 @ResponseBody
 public Department getDepartment(@PathVariable("id") String id) {
  return erpService.findDepartmentById(id);
 }

 //查找全部部门信息
 @RequestMapping("department/list")
 @ResponseBody
 public List<Department> findDepartment() {
  return erpService.findDepartment();
 }

 //对前端页面映射
 @RequestMapping("department/add_judge")
 @ResponseBody
 public Map<String, String> addDepartmentJudge(Department department) {

  return new HashMap<>();
 }

 @RequestMapping("department/add")
 public String addDepartment() {
  return "department_add";
 }

 //增加department
 @RequestMapping("department/insert")
 @ResponseBody
 public Map<String, String> insertDepartment(Department department) {
  Map<String, String> map = new HashMap<>();
  int i = erpService.addDepartment(department);
  map.put("status", "200");
  if (i != 1) {
   map.put("msg", "添加异常");
  }
  return map;
 }

 //编辑department
 @RequestMapping("department/edit_judge")
 @ResponseBody
 public Map<String, String> editDepartmentJudge(Department department) {
  return new HashMap<>();
 }

 @RequestMapping("department/edit")
 public String editDepartment() {
  return "department_edit";
 }

 @RequestMapping("department/update_all")
 @ResponseBody
 public Map<String, String> updateDepartment(Department department) {
  int i = erpService.editDepartment(department);
  HashMap<String, String> map = new HashMap<>();
  map.put("status", "200");
  if (i != 1) {
   map.put("msg", "更新异常");
  }
  return map;
 }

 //删除department
 @RequestMapping("department/delete_judge")
 @ResponseBody
 public Map<String, String> deleteDepartmentJudge(Department department) {
  return new HashMap<>();
 }

 @RequestMapping("department/delete_batch")
 @ResponseBody
 public Map<String, String> deleteDepartmentBatch(String[] ids) {
  Map<String, String> map = new HashMap<>();
  map.put("status", "200");
  int i = erpService.deleteDepartment(ids);
  for (String id : ids) {
   if (i != ids.length) {
    map.put("msg", "删除异常");
   }
  }
   return map;
 }
 @RequestMapping("department/get_data")
 @ResponseBody
 public List<Department> getDepartmentData(){
  return erpService.findDepartment();
 }
}