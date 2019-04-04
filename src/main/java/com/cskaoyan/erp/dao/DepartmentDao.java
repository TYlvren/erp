package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Department;

import java.util.List;

public interface DepartmentDao {

 List<Department> selectDepartment();

 Department selectDepartmentById(String id);

 int insertDepartment(Department department);

 int updateDepartment(Department product);

 int deleteDepartmentById(String[] ids);

}