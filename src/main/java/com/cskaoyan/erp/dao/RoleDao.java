package com.cskaoyan.erp.dao;

import com.cskaoyan.erp.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    List<Role> selectAllRole();

    Role selectRoleById(String id);

    int insertRole(Role role);

    int updateRole(Role role);

    int deleteRoleByIds(String[] ids);

    List<Role> selectRoleBySearch(@Param("condition") String condition,@Param("searchValue") String searchValue);
}
