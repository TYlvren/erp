package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.model.COrder;
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
        session.setAttribute("user",sysUser);
        map.put("msg","ok");
        return map;
    }

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
     * Order的模糊查找
     */
    @RequestMapping("user/search_order_by_user{condition}")
    @ResponseBody
    public Object findPageUserBySearch(@RequestParam int page, @RequestParam int rows,
                                       String searchValue, @PathVariable String condition) {
        List<COrder> list = erpService.findUserBySearch(condition, searchValue);
        return list;
    }


    private Map<String, String> getStatusMap(int i) {
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        if (i != 1) {
            map.put("msg", "异常");
        }
        return map;
    }
}
