package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.model.Employee;
import com.cskaoyan.erp.service.ErpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zi_an
 * Date 2019/4/4 time 22:20
 */
@Controller("employeeController")
@RequestMapping("employee")
public class EmployeeController {
 @Autowired
 private ErpService erpService;


 @RequestMapping("/find")
 public String find(HttpSession httpSession){
  //增删改三个按钮
  List<String> sysPermissonList = (ArrayList<String>) httpSession.getAttribute("sysPermissonList");
  // session 是各个模块共用的，所以可能会覆盖其他模块的sysPermission

  if (sysPermissonList == null){
   sysPermissonList = new ArrayList<>();
  }

  if (!sysPermissonList.contains("employee:add")){
   sysPermissonList.add("employee:add");
   sysPermissonList.add("employee:edit");
   sysPermissonList.add("employee:delete");
   httpSession.setAttribute("sysPermissionList", sysPermissonList);
  }

  return "employee_list";

 }
 @RequestMapping("/list")
 public @ResponseBody List<Employee> findAllEmployee() {
  List<Employee> employees = erpService.findAllEmployee();
  return employees;
 }

 //增加
 //抓包看到响应报文为空的json
 @RequestMapping("/add_judge")
 @ResponseBody
 public void addJudge(){
  return ;
 }

 //显示department_add.jsp
 @RequestMapping("/add")
 public String add(){
  return "employee_add";
 }

 @RequestMapping("/insert")
 @ResponseBody
 public Map<String, String> insertEmployee(Employee employee, String departmentId){
  int b = erpService.insertEmployee(employee, departmentId);
  Map<String, String> map = new HashMap<>();
  map.put("status", "200");
  if (b != 1){
   map.put("msg", "添加异常");
  }
  return map;
 }

 //抓包看到响应报文为空的json
 @RequestMapping("/edit_judge")
 @ResponseBody
 public void editJudge(){
  return;
 }

 //显示department_edit.jsp
 @RequestMapping("/edit")
 public String edit(){
  return "employee_edit";
 }

 @RequestMapping("/update_all")
 @ResponseBody
 public Map<String, String> updateAll(Employee employee){
  int update = erpService.updateByPrimaryKey(employee);
  Map<String, String> map = new HashMap<>();
  map.put("status", "200");
  if (update != 1){
   map.put("msg", "编辑异常");
  }
  return map;
 }


 @RequestMapping("/get_data")
 @ResponseBody
 public List<Employee> getEmployeetData() {
  List<Employee> employees = erpService.findAllEmployee();
  return employees;
 }

 //删除
 @RequestMapping("/delete_judge")
 @ResponseBody
 public void deleteJudge(){
  return;
 }

 @RequestMapping("/delete_batch")
 @ResponseBody
 public Map<String, String> deleteBatch(String[] ids){
  Map<String, String> map = new HashMap<>();
  map.put("status", "200");
  int i = erpService.deleteEmployee(ids);

  if (i != ids.length){
   map.put("msg", "删除异常");
  }
  return map;
 }


 //根据员工编号查询
 @RequestMapping("/search_employee_by_employeeId")
 public @ResponseBody
 List<Employee> queryByEmployeeId(String searchValue) {
  List<Employee> employees = erpService.queryByEmployeeId(searchValue);
  return employees;
 }


 //根据员工名称查询
 @RequestMapping("/search_employee_by_employeeName")
 public @ResponseBody
 List<Employee> queryByEmployeeName(String searchValue) {
  List<Employee> employees = erpService.queryByEmployeeName(searchValue);
  return employees;
 }

 //根据部门名称查询
 @RequestMapping("/search_employee_by_departmentName")
 public @ResponseBody
 List<Employee> queryByDepartmentName(String searchValue) {
  List<Employee> employees = erpService.queryByDepartmentName(searchValue);
  return employees;
 }


}
