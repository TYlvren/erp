package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {

List<Employee> selectAllEmployee();

Employee selectEmployeeById(String id);

int insertEmployee(@Param("employee") Employee employee);

int updateEmployee(Employee employee);

int deleteEmployeeByIds(String[] ids);

}