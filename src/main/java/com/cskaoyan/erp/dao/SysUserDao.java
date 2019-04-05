package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.COrder;
import com.cskaoyan.erp.model.SysUser;

import java.util.List;

public interface SysUserDao {

    List<SysUser> selectAllUser();

    SysUser selectAllUserById();

    int insertUser(SysUser sysUser);

    int addUser(SysUser user);

    int deleteUserByIds(String[] ids);

    SysUser selectUserByUsernameAndPassword(String username, String password);

    List<COrder> selectUserBySearch(String condition, String searchValue);

    SysUser selectUsername(String username);
}