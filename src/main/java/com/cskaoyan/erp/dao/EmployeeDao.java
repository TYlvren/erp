package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Employee;

public interface EmployeeDao {
 int deleteByPrimaryKey(String empId);

 int insert(Employee record);

 int insertSelective(Employee record);

 Employee selectByPrimaryKey(String empId);

 int updateByPrimaryKeySelective(Employee record);

 int updateByPrimaryKey(Employee record);

}