package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.COrder;
import com.cskaoyan.erp.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserDao {

    List<SysUser> selectAllUser();

    SysUser selectAllUserById();

    int insertUser(SysUser sysUser);

    int addUser(SysUser user);

    int deleteUserByIds(String[] ids);

    SysUser selectUserByUsernameAndPassword(@Param("username") String username,@Param("password") String password);

    List<COrder> selectUserBySearch(@Param("condition") String condition,@Param("searchValue") String searchValue);


    SysUser selectUserByUsername(String username);
}