/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UnqualifyController
 * Author:   john
 * Date:     2019/4/3 15:42
 * Description: 不合格品管理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.model.UnQualifyApply;
import com.cskaoyan.erp.service.ErpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.deploy.net.HttpResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.security.x509.UniqueIdentity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈不合格品管理〉
 *
 * @author john
 * @create 2019/4/3
 * @since 1.0.0
 */

@Controller
@RequestMapping("unqualify")
public class UnqualifyController {
    @Autowired
    @Qualifier("erpService")
    private ErpService erpService;//注入service容器


    @RequestMapping("find")//进入情况1.home.jsp中点击不合格品管理
    public String turnToUnqualify(ModelAndView mv, HttpSession session){
        List<String> sysPermissionList=new ArrayList<>();
        sysPermissionList.add("unqualify:add");//设置新建编辑删除按钮的显示
        sysPermissionList.add("unqualify:edit");
        sysPermissionList.add("unqualify:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "unqualify_list";
    }
    @RequestMapping("list")//自动查询数据  实现分页
    public  @ResponseBody Map<String, Object> findUnqualify(@RequestParam int page, int rows){
        PageHelper.startPage(page, rows, true);
        List<UnQualifyApply> list = erpService.findUnqualifyList();
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
    @RequestMapping("add")//新建不合格品记录
    public String addUniqualify(){
       return "unqualify_add";
    }
    @RequestMapping("add_judge")//新建不合格品记录
    @ResponseBody
    public String addJudgeUniqualify()  {
        return "{}";
    }

    @RequestMapping("insert")//新建不合格品记录
    @ResponseBody
    public Map<String,String > insertUnQualifyApply(UnQualifyApply unQualifyApply)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        erpService.addUnqualifyService(unQualifyApply);//添加商品没有返回值
        return map;
    }

    @RequestMapping("edit_judge")//新建不合格品记录
    @ResponseBody
    public String editUnqualifyJudge()  {
        return "{}";
    }

    @RequestMapping("edit")//编辑不合格品
    public String editUniqualify(){
        return "unqualify_edit";
    }

    @RequestMapping("update_all")//修改不合格品记录
    @ResponseBody
    public Map<String,String > updateUnQualifyApply(UnQualifyApply unQualifyApply)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.updateUnqualifyService(unQualifyApply);//修改商品没有返回值
        return map;
    }

    @RequestMapping("delete_judge")//新建不合格品记录
    @ResponseBody
    public String deleteJudgeUnqualifyJudge()  {
        return "{}";
    }

    @RequestMapping("delete_batch")//删除不合格品记录(可为多条)
    @ResponseBody
    public Map<String,String > deleteUnQualifyApply(String[] ids)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.deleteUnqualifyService(ids);//删除商品
        return map;
    }
    @RequestMapping("update_note")//更新不合格品记录备注属性
    @ResponseBody
    public Map<String,String > updateNoteUnQualifyApply(String unqualifyApplyId,String note)  {
        System.out.println(unqualifyApplyId+note);
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.updateNoteUnqualifyService(unqualifyApplyId,note);//删除商品
        return map;
    }




}
