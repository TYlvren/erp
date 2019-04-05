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

import com.cskaoyan.erp.model.ProcessMeasureCheck;
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
public class QualityController {
    @Autowired
    @Qualifier("erpService")
    private ErpService erpService;//注入service容器


    /**********************不合格品质量管理模块********************************************/

    @RequestMapping("unqualify/find")//进入情况1.home.jsp中点击不合格品管理
    public String turnToUnqualify(ModelAndView mv, HttpSession session){
        List<String> sysPermissionList=new ArrayList<>();
        sysPermissionList.add("unqualify:add");//设置新建编辑删除按钮的显示
        sysPermissionList.add("unqualify:edit");
        sysPermissionList.add("unqualify:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "unqualify_list";
    }
    @RequestMapping("unqualify/list")//自动查询数据  实现分页
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
    @RequestMapping("unqualify/add")//新建不合格品记录
    public String addUniqualify(){
       return "unqualify_add";
    }
    @RequestMapping("unqualify/add_judge")//新建不合格品记录
    @ResponseBody
    public String addJudgeUniqualify()  {
        return "{}";
    }
    @RequestMapping("unqualify/insert")//新建不合格品记录
    @ResponseBody
    public Map<String,String > insertUnQualifyApply(UnQualifyApply unQualifyApply)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        erpService.addUnqualifyService(unQualifyApply);//添加商品没有返回值
        return map;
    }
    @RequestMapping("unqualify/edit_judge")//新建不合格品记录
    @ResponseBody
    public String editUnqualifyJudge()  {
        return "{}";
    }
    @RequestMapping("unqualify/edit")//编辑不合格品
    public String editUniqualify(){
        return "unqualify_edit";
    }
    @RequestMapping("unqualify/update_all")//修改不合格品记录
    @ResponseBody
    public Map<String,String > updateUnQualifyApply(UnQualifyApply unQualifyApply)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.updateUnqualifyService(unQualifyApply);//修改商品没有返回值
        return map;
    }
    @RequestMapping("unqualify/delete_judge")//新建不合格品记录
    @ResponseBody
    public String deleteJudgeUnqualifyJudge()  {
        return "{}";
    }
    @RequestMapping("unqualify/delete_batch")//删除不合格品记录(可为多条)
    @ResponseBody
    public Map<String,String > deleteUnQualifyApply(String[] ids)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.deleteUnqualifyService(ids);//删除商品
        return map;
    }
    @RequestMapping("unqualify/update_note")//更新不合格品记录备注属性
    @ResponseBody
    public Map<String,String > updateNoteUnQualifyApply(String unqualifyApplyId,String note)  {
        System.out.println(unqualifyApplyId+note);
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.updateNoteUnqualifyService(unqualifyApplyId,note);//删除商品
        return map;
    }

    /********************************成品计量质检模块******************************************************************/

//    @RequestMapping("measure/find")//进入情况1.home.jsp中点击成品计量质检
//    public String turnToPMeasureCheck(ModelAndView mv, HttpSession session){
//        List<String> sysPermissionList=new ArrayList<>();
//        sysPermissionList.add("pMeasureCheck:add");//设置新建编辑删除按钮的显示
//        sysPermissionList.add("pMeasureCheck:edit");
//        sysPermissionList.add("pMeasureCheck:delete");
//        session.setAttribute("sysPermissionList",sysPermissionList);
//        return "p_measure_check_list";
//    }
//
//    @RequestMapping("p_measure_check/list")//自动查询成品计量质检数据  实现分页
//    public  @ResponseBody Map<String, Object> findPMeasureCheck(@RequestParam int page, int rows){
//        PageHelper.startPage(page, rows, true);
//        List<ProcessMeasureCheck> list = erpService.findPMeasureCheck();
//        PageInfo pageInfo = new PageInfo(list);
//        list = pageInfo.getList();
//        long total = pageInfo.getTotal();
//        Map<String, Object> map = new HashMap<>();
//        map.put("total", total);
//        map.put("rows", list);
//        return map;
//    }
//    @RequestMapping("p_measure_check/add")//新建成品计量质检转入对应jsp
//    public String addPMeasureCheck(){
//        return "p_measure_check_add";
//    }
//    @RequestMapping("pMeasureCheck/add_judge")//计量质检判断
//    @ResponseBody
//    public String addJudgePMeasureCheck()  {
//        return "{}";
//    }
//
//
//    @RequestMapping("unqualify/insert")//新建成品计量质检记录
//    @ResponseBody
//    public Map<String,String > insertUnQualifyApply(ProcessMeasureCheck processMeasureCheck)  {
//        Map<String,String > map = new HashMap<>();
//        map.put("status","200");
//        map.put("msg","OK");
//        erpService.addPMeasureCheckService(processMeasureCheck);//添加商品没有返回值
//        return map;
//    }
/********************************成品计数质检模块******************************************************************/
/********************************工序计量质检模块******************************************************************/
@RequestMapping("p_measure_check/find")//进入情况1.home.jsp中点击工序计量质检
public String turnToPMeasureCheck(ModelAndView mv, HttpSession session){
    List<String> sysPermissionList=new ArrayList<>();
    sysPermissionList.add("pMeasureCheck:add");//设置新建编辑删除按钮的显示
    sysPermissionList.add("pMeasureCheck:edit");
    sysPermissionList.add("pMeasureCheck:delete");
    session.setAttribute("sysPermissionList",sysPermissionList);
    return "p_measure_check_list";
}

    @RequestMapping("p_measure_check/list")//自动查询工序计量质检数据  实现分页
    public  @ResponseBody Map<String, Object> findPMeasureCheck(@RequestParam int page, int rows){
        PageHelper.startPage(page, rows, true);
        List<ProcessMeasureCheck> list = erpService.findPMeasureCheck();
        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
    @RequestMapping("p_measure_check/add")//新建工序计量质检转入对应jsp
    public String addPMeasureCheck(){
        return "p_measure_check_add";
    }
    @RequestMapping("pMeasureCheck/add_judge")//工序质检判断
    @ResponseBody
    public String addJudgePMeasureCheck()  {
        return "{}";
    }


    @RequestMapping("p_measure_check/insert")//新建工序计量质检记录
    @ResponseBody
    public Map<String,String > insertUnQualifyApply(ProcessMeasureCheck processMeasureCheck)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        erpService.addPMeasureCheckService(processMeasureCheck);//添加商品没有返回值
        return map;
    }
/********************************工序计数质检模块******************************************************************/


}