package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.model.Employee;
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
 * @author zi_an
 * Date 2019/4/4 time 22:20
 */
@Controller
public class EmployeeController {
 @Autowired
 private ErpService erpService;
@RequestMapping("employee/find")
public String find(HttpSession httpSession) {
 List<String> sysPermissionList = (ArrayList<String>) httpSession.getAttribute("sysPermissionList");
 if (sysPermissionList == null) {
  sysPermissionList = new ArrayList<>();
 }
 if (!sysPermissionList.contains("employee:add")) {
  sysPermissionList.add("employee:add");
  sysPermissionList.add("employee:edit");
  sysPermissionList.add("employee:delete");
  httpSession.setAttribute("sysPermissionList", sysPermissionList);
 }
 return "employee_list";
}

@RequestMapping("employee/get/{id}")
 @ResponseBody
 public Employee getEmployee(@PathVariable("id") String id){
 return erpService.findEmployeeById(id);
}

 @RequestMapping("employee/list")
 @ResponseBody
 public List<Employee> findEmployee() {
  return erpService.findEmployee();
 }

@RequestMapping("employee/add_judge")
 @ResponseBody
 public Map<String,String> addEmployeeJudge(Employee employee){
 return new HashMap<>();
}
@RequestMapping("employee/add")
 public String addEmployee(){
 return "employee_add";
}
@RequestMapping("employee/insert")
 @ResponseBody
 public Map<String,String> insertEmployee(Employee employee){
 Map<String, String> map = new HashMap<>();
 int i = erpService.addEmployee(employee);
 map.put("status", "200");
 if (i != 1) {
  map.put("msg", "添加异常");
 }
 return map;
}
@RequestMapping("employee/edit_judge")
 @ResponseBody
 public Map<String,String> editEmployeeJudge(Employee employee){
 return new HashMap<>();
}
@RequestMapping("employee/edit")
 public String editEmployee(){
 return "employee_edit";
}
@RequestMapping("employee/update_all")
 @ResponseBody
 public Map<String,String> updateEmployee(Employee employee){
 int i = erpService.editEmployee(employee);
 HashMap<String, String> map = new HashMap<>();
 map.put("status", "200");
 if (i != 1) {
  map.put("msg", "更新异常");
 }
 return map;
}
@RequestMapping("employee/delete_judge")
 @ResponseBody
 public Map<String,String> deleteEmployeeJudge(Employee employee){
 return new HashMap<>();
}
@RequestMapping("employee/delete_batch")
 @ResponseBody
 public Map<String,String> deleteEmployeeBatch(String[] ids){
 Map<String, String> map = new HashMap<>();
 map.put("status", "200");
 int i = erpService.deleteEmployee(ids);
 for (String id : ids) {
  if (i != ids.length) {
   map.put("msg", "删除异常");
  }
 }
 return map;
}
@RequestMapping("employee/get_data")
 @ResponseBody
 public List<Employee> getEmployeeData(){
  return erpService.findEmployee();
 }
}
