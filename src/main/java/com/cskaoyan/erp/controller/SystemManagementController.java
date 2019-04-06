package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.model.Role;
import com.cskaoyan.erp.model.SysUser;
import com.cskaoyan.erp.service.ErpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SystemManagementController {
    @Autowired
    private ErpService erpService;

    /*****************User控制层*************************************/
    /**
     * 登录注册user的controller
     */
    @RequestMapping("ajaxLogin")
    @ResponseBody
    public Map<String,String> login(String username, String password, HttpSession session) {
        Map<String,String> map = new HashMap<>();
        SysUser sysUser = erpService.findUserByUsername(username);
        if (sysUser == null) {
            map.put("msg","account_error");
            return map;
        }
        sysUser = erpService.findUserByUsernameAndPassword(username, password);
        if(sysUser == null){
            map.put("msg","password_error");
            return map;
        }
        if ("0".equals(sysUser.getLocked())){
            map.put("msg","authentication_error");
            return map;
        }
        Role role = new Role();
        role.setRoleName("超级管理员");
        sysUser.setRole(role);
        session.setAttribute("activeUser",sysUser);
        map.put("msg","ok");
        return map;
    }

    @RequestMapping("home")
    public String toHome(){
        return "home";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        if(session != null){
            session.invalidate();
        }
        return "index";
    }

    /**
     * 查找user的controller
     */
    @RequestMapping("user/find")
    public String toOrderList(HttpSession session) {
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("user:add");
        sysPermissionList.add("user:edit");
        sysPermissionList.add("user:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "user_list";
    }

    @ResponseBody
    @RequestMapping("user/list")
    public Object findPageUser(@RequestParam int page, @RequestParam int rows) {
        return erpService.findUser();
    }

    @RequestMapping("user/get/{id}")
    @ResponseBody
    public SysUser getUser(@PathVariable("id") String id) {
        return erpService.findUserById(id);
    }

    @ResponseBody
    @RequestMapping("user/get_data")
    public List<SysUser> getUserData() {
        return erpService.findUser();
    }

    /**
     * 添加user的controller
     */
    @RequestMapping("user/add_judge")
    @ResponseBody
    public Map<String, String> addUserJudge(SysUser sysUser) {
        return new HashMap<>();
    }

    @RequestMapping("user/add")
    public String addUser() {
        return "user_add";
    }

    @RequestMapping("user/insert")
    @ResponseBody
    public Map<String, String> insertUser(SysUser sysUser) {
        int i = erpService.addUser(sysUser);
        return getStatusMap(i);
    }


    /**
     * 编辑user的controller
     */
    @RequestMapping("user/edit_judge")
    @ResponseBody
    public Map<String, String> editUserJudge(SysUser user) {
        return new HashMap<>();
    }

    @RequestMapping("user/edit")
    public String editUser() {
        return "user_edit";
    }

    @RequestMapping("user/update_all")
    @ResponseBody
    public Map<String, String> updateUser(SysUser user) {
        int i = erpService.editUser(user);
        return getStatusMap(i);
    }


    /**
     * 删除user的controller
     */
    @RequestMapping("user/delete_judge")
    @ResponseBody
    public Map<String, String> deleteUserJudge(SysUser user) {
        return new HashMap<>();
    }

    @RequestMapping("user/delete_batch")
    @ResponseBody
    public Map<String, String> deleteUserBatch(String[] ids) {
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        int i = erpService.deleteUser(ids);

        if (i != ids.length) {
            map.put("msg", "异常");
        }
        return map;
    }

    /**
     * User的模糊查找
     */
    @RequestMapping("user/search_order_by_user{condition}")
    @ResponseBody
    public Object findPageUserBySearch(@RequestParam int page, @RequestParam int rows,
                                       String searchValue, @PathVariable String condition) {
        return erpService.findUserBySearch(condition, searchValue);
    }


    private Map<String, String> getStatusMap(int i) {
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        if (i != 1) {
            map.put("msg", "异常");
        }
        return map;
    }

    /*****************Role控制层*************************************/
    /**
     * 查找role的controller
     */
    @RequestMapping("role/find")
    public String toRoleList(HttpSession session) {
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("role:add");
        sysPermissionList.add("role:edit");
        sysPermissionList.add("role:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "role_list";
    }

    @ResponseBody
    @RequestMapping("role/list")
    public Object findPageRole(@RequestParam int page, @RequestParam int rows) {
        return erpService.findRole();
    }

    @RequestMapping("role/get/{id}")
    @ResponseBody
    public Role getRole(@PathVariable("id") String id) {
        return erpService.findRoleById(id);
    }

    @ResponseBody
    @RequestMapping("role/get_data")
    public List<Role> getRoleData() {
        return erpService.findRole();
    }

    /**
     * 添加role的controller
     */
    @RequestMapping("role/add_judge")
    @ResponseBody
    public Map<String, String> addRoleJudge(Role role) {
        return new HashMap<>();
    }

    @RequestMapping("role/add")
    public String addRole() {
        return "role_add";
    }

    @RequestMapping("role/insert")
    @ResponseBody
    public Map<String, String> insertRole(Role role) {
        int i = erpService.addRole(role);
        return getStatusMap(i);
    }


    /**
     * 编辑role的controller
     */
    @RequestMapping("role/edit_judge")
    @ResponseBody
    public Map<String, String> editRoleJudge(Role role) {
        return new HashMap<>();
    }

    @RequestMapping("role/edit")
    public String editRole() {
        return "role_edit";
    }

    @RequestMapping("role/update_all")
    @ResponseBody
    public Map<String, String> updateRole(Role role) {
        int i = erpService.editRole(role);
        return getStatusMap(i);
    }


    /**
     * 删除role的controller
     */
    @RequestMapping("role/delete_judge")
    @ResponseBody
    public Map<String, String> deleteRoleJudge(Role role) {
        return new HashMap<>();
    }

    @RequestMapping("role/delete_batch")
    @ResponseBody
    public Map<String, String> deleteRoleBatch(String[] ids) {
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        int i = erpService.deleteRole(ids);

        if (i != ids.length) {
            map.put("msg", "异常");
        }
        return map;
    }

    /**
     * role的模糊查找
     */
    @RequestMapping("role/search_order_by_role{condition}")
    @ResponseBody
    public Object findPageRoleBySearch(@RequestParam int page, @RequestParam int rows,
                                       String searchValue, @PathVariable String condition) {
        return erpService.findRoleBySearch(condition, searchValue);
    }

}
