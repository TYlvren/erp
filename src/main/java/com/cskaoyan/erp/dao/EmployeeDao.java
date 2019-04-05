package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {

 List<Employee> findAllEmployee();
 //模糊搜索查询
 List<Employee>  queryByEmployeeId(String empId);

 List<Employee>  queryByEmployeeName(String empName);

 List<Employee>  queryByDepartmentName(String departmentName);

 //多表查询可能要用的接口
 Employee getEmployeeByEmployeeId(String empId);


 //多参数要用Param注解
 int insertEmployee(@Param("employee") Employee employee, @Param("departmentId") String departmentId);

 //多参数要用Param注解
 int update(@Param(("employee")) Employee  employee, @Param("departmentId") String departmentId);



 int deleteByPrimaryKey(String empId);

 int insert(Employee record);

 int insertSelective(Employee record);

 Employee selectByPrimaryKey(String empId);

 int updateByPrimaryKeySelective(Employee record);

 int updateByPrimaryKey(Employee record);

 int deleteEmployee(String[] ids);

 Employee findEmployeeById(@Param("id") String empId);
}