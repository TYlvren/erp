package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentDao {
 //查询所有部门信息
 List<Department> selectDepartment();



 int insertDepartment(@Param("department") Department department);

  boolean deleteByDepartmentId(String departmentId);


 int insertSelective(Department record);

 Department selectByPrimaryKey(String departmentId);

 int updateByPrimaryKeySelective(Department record);

 int updateByPrimaryKey(Department record);

}