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

import com.cskaoyan.erp.model.*;
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
    /**
     * @param mv
     * @param session
     * @return unqualify_list
     * 跳转到不合格品管理的jsp页面
     */
    @RequestMapping("unqualify/find")
    public String turnToUnqualify(ModelAndView mv, HttpSession session){
        List<String> sysPermissionList=new ArrayList<>();
        sysPermissionList.add("unqualify:add");//设置新建编辑删除按钮的显示
        sysPermissionList.add("unqualify:edit");
        sysPermissionList.add("unqualify:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "unqualify_list";
    }
    /**
     *
     * @param page
     * @param rows
     * @return Object
     * 动态查询不合格列表数据返回列表数据类型为Object类由aop方法进行分页
     */
    @RequestMapping("unqualify/list")
    @ResponseBody
    public   Object findPageUnqualify(int page, int rows){
        return erpService.findUnqualifyList();
    }
    /**
     * @return unqualify_add
     * 新增不合格品记录返回对应jsp页面
     */
    @RequestMapping("unqualify/add")
    public String addUniqualify(){
       return "unqualify_add";
    }
    /**
     * @return {}
     * 用来作为添加判断
     */
    @RequestMapping("unqualify/add_judge")
    @ResponseBody
    public String addJudgeUniqualify()  {
        return "{}";
    }

    /**
     *
     * @param unQualifyApply
     * @return map
     * 新建不合格品记录 返回json数据用来判断是否添加成功
     */
    @RequestMapping("unqualify/insert")
    @ResponseBody
    public Map<String,String > insertUnQualifyApply(UnQualifyApply unQualifyApply)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        erpService.addUnqualifyService(unQualifyApply);
        return map;
    }

    /**
     *
     * @return {}
     * 作为修改判断
     */
    @RequestMapping("unqualify/edit_judge")
    @ResponseBody
    public String editUnqualifyJudge()  {
        return "{}";
    }
    /**
     *
     * @return unqualify_edit
     * 返回不合格品修改页面
     */
    @RequestMapping("unqualify/edit")
    public String editUniqualify(){
        return "unqualify_edit";
    }

    /**
     *
     * @param unQualifyApply
     * @return map
     * 修改不合格品记录
     */
    @RequestMapping("unqualify/update_all")
    @ResponseBody
    public Map<String,String > updateUnQualifyApply(UnQualifyApply unQualifyApply)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.updateUnqualifyService(unQualifyApply);
        return map;
    }

    /**
     *
     * @return {}
     * 删除不合格品记录判断
     */
    @RequestMapping("unqualify/delete_judge")
    @ResponseBody
    public String deleteJudgeUnqualifyJudge()  {
        return "{}";
    }

    /**
     *
     * @param ids
     * @return map
     * 删除不合格品记录
     */
    @RequestMapping("unqualify/delete_batch")
    @ResponseBody
    public Map<String,String > deleteUnQualifyApply(String[] ids)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.deleteUnqualifyService(ids);
        return map;
    }

    /**
     *
     * @param unqualifyApplyId
     * @param note
     * @return map
     * 修改不合格品记录备注
     */
    @RequestMapping("unqualify/update_note")
    @ResponseBody
    public Map<String,String > updateNoteUnQualifyApply(String unqualifyApplyId,String note)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.updateNoteUnqualifyService(unqualifyApplyId,note);
        return map;
    }

    /**
     *
     * @param page
     * @param rows
     * @param searchname
     * @param searchValue
     * @return Object
     * 查询不合格品
     */
    @RequestMapping("unqualify/search_unqualify_by_{name}")
    @ResponseBody
    public Object findPageSearchUnqualify(int page,int rows,@PathVariable("name") String searchname,String searchValue)  {
        return erpService.searchUnqualifyService(searchname,searchValue);
    }

    /********************************成品计量质检模块******************************************************************/
    /**
     *
     * @param mv
     * @param session
     * @return measurement_list
     * 设置相关按钮跳转成品计量质检页面
     */
    @RequestMapping("measure/find")
    public String turnToFMeasureCheck(ModelAndView mv, HttpSession session){
        List<String> sysPermissionList=new ArrayList<>();
        sysPermissionList.add("fMeasureCheck:add");
        sysPermissionList.add("fMeasureCheck:edit");
        sysPermissionList.add("fMeasureCheck:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "measurement_list";
    }

    /**
     *
     * @param page
     * @param rows
     * @return Object
     * 查询成品计量质检数据  实现分页
     */
    @RequestMapping("measure/list")
    @ResponseBody
    public Object findPageFMeasureCheck( int page, int rows){
        return erpService.findFMeasureCheck();
    }

    /**
     *
     * @return measurement_add
     * 新建成品计量质检转入对应jsp
     */
    @RequestMapping("measure/add")
    public String addFMeasureCheck(){
        return "measurement_add";
    }

    /**
     *
     * @return {}
     * 成品计量质检判断
     */
    @RequestMapping("fMeasureCheck/add_judge")
    @ResponseBody
    public String addJudgeFMeasureCheck()  {
        return "{}";
    }

    /**
     *
     * @param finalMeasureCheck
     * @return map
     * 新建成品计量质检记录
     */
    @RequestMapping("measure/insert")
    @ResponseBody
    public Map<String,String > insertFMeasureCheck(FinalMeasureCheck finalMeasureCheck)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        erpService.addFMeasureCheckService(finalMeasureCheck);
        return map;
    }

    /**
     *
     * @return {}
     * 判断修改成品计量质检记录
     */
    @RequestMapping("fMeasureCheck/edit_judge")
    @ResponseBody
    public String editJudgeFMeasureCheck()  {
        return "{}";
    }

    /**
     *
     * @return measurement_edit
     *跳转修改成品计量质检页面
     */
    @RequestMapping("measure/edit")
    public String editFMeasureCheck(){
        return "measurement_edit";
    }

    /**
     *
     * @param finalMeasureCheck
     * @return map
     * 修改成品计量质检记录
     */
    @RequestMapping("measure/update_all")
    @ResponseBody
    public Map<String,String > updateFMeasureCheck(FinalMeasureCheck finalMeasureCheck)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.updateFMeasureCheckService(finalMeasureCheck);
        return map;
    }

    /**
     *
     * @return {}
     * 删除成品计量质检记录
     */
    @RequestMapping("fMeasureCheck/delete_judge")
    @ResponseBody
    public String deleteJudgeFMeasureCheck()  {
        return "{}";
    }

    /**
     *
     * @param ids
     * @return map
     * 删除成品计量质检记录
     */
    @RequestMapping("measure/delete_batch")
    @ResponseBody
    public Map<String,String > deleteFMeasureCheck(String[] ids)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.deleteFMeasureCheckService(ids);
        return map;
    }

    /**
     *
     * @param fMeasureCheckId
     * @param note
     * @return map
     * 修改成品计量质检记录备注属性
     */
    @RequestMapping("measure/update_note")
    @ResponseBody
    public Map<String,String > updateNoteFMeasureCheck(String fMeasureCheckId,String note)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.updateNoteFMeasureCheckService(fMeasureCheckId,note);
        return map;
    }

    /**
     *
     * @param page
     * @param rows
     * @param searchname
     * @param searchValue
     * @return Object
     * 模糊查询成品计量质检记录
     */
    @RequestMapping("measure/search_fMeasureCheck_by_{name}")
    @ResponseBody
    public Object findPageSearchFMeasureCheck(int page,int rows,@PathVariable("name") String searchname,String searchValue)  {
        return erpService.searchFMeasureCheckService(searchname,searchValue);
    }
/********************************成品计数质检模块******************************************************************/

    /**
     *
     * @param mv
     * @param session
     * @return f_count_check_list
     * 跳转成品计数质检及按钮显示
     */
    @RequestMapping("f_count_check/find")
public String turnToFCountCheck(ModelAndView mv, HttpSession session){
    List<String> sysPermissionList=new ArrayList<>();
    sysPermissionList.add("fCountCheck:add");
    sysPermissionList.add("fCountCheck:edit");
    sysPermissionList.add("fCountCheck:delete");
    session.setAttribute("sysPermissionList",sysPermissionList);
    return "f_count_check_list";
}

    /**
     *
     * @param page
     * @param rows
     * @return Object
     * 自动查询成品计数质检数据
     */
    @RequestMapping("f_count_check/list")
    @ResponseBody
    public Object findPageFCountCheck( int page, int rows){
        return erpService.findFCountCheck();
    }

    /**
     *
     * @return f_count_check_add
     * 新建成品计数质检入对应jsp
     */
    @RequestMapping("f_count_check/add")
    public String addFCountCheck(){
        return "f_count_check_add";
    }

    /**
     *
     * @return {}
     * 成品计数质检判断
     */
    @RequestMapping("fCountCheck/add_judge")
    @ResponseBody
    public String addJudgeFCountCheck()  {
        return "{}";
    }

    /**
     *
     * @param finalCountCheck
     * @return map
     * 新建成品计数质检记录
     */
    @RequestMapping("f_count_check/insert")
    @ResponseBody
    public Map<String,String > insertFCountCheck(FinalCountCheck finalCountCheck)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        erpService.addFCountCheckService(finalCountCheck);
        return map;
    }

    /**
     * 修改成品计数质检记录
     * @return {}
     */
    @RequestMapping("fCountCheck/edit_judge")//
    @ResponseBody
    public String editJudgeFCountCheck()  {
        return "{}";
    }

    /**
     * 跳转修改成品计数质检页面
     * @return f_count_check_edit
     */
    @RequestMapping("f_count_check/edit")
    public String editFCountCheck(){
        return "f_count_check_edit";
    }

    /**
     * 修改成品计数质检记录
     * @param finalCountCheck
     * @return map
     *
     */
    @RequestMapping("f_count_check/update_all")//
    @ResponseBody
    public Map<String,String > updateFCountCheck(FinalCountCheck finalCountCheck)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.updateFCountCheckService(finalCountCheck);
        return map;
    }

    /**
     * 删除成品计数质检记录判断
     * @return {}
     */
    @RequestMapping("fCountCheck/delete_judge")//
    @ResponseBody
    public String deleteJudgeFCountCheck()  {
        return "{}";
    }

    /**
     * 删除成品计数质检记录
     * @param ids
     * @return mao
     */
    @RequestMapping("f_count_check/delete_batch")
    @ResponseBody
    public Map<String,String > deleteFCountCheck(String[] ids)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.deleteFCountCheckService(ids);
        return map;
    }

    /**
     * 更新成品计数质检记录备注属性
     * @param fCountCheckId
     * @param note
     * @return
     */
    @RequestMapping("f_count_check/update_note")
    @ResponseBody
    public Map<String,String > updateNoteFCountCheck(String fCountCheckId,String note)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.updateNoteFCountCheckService(fCountCheckId,note);
        return map;
    }

    /**
     * 模糊查询成品计数质检记录
     * @param page
     * @param rows
     * @param searchname
     * @param searchValue
     * @return Object
     */
    @RequestMapping("f_count_check/search_fCountCheck_by_{name}")
    @ResponseBody
    public Object findPageSearchFCountCheck(int page,int rows,@PathVariable("name") String searchname,String searchValue)  {
        return erpService.searchFCountCheckService(searchname,searchValue);
    }

/********************************工序计量质检模块******************************************************************/
    /**
     * 跳转工序计量质检页面
     * @param mv
     * @param session
     * @return p_measure_check_list
     */
@RequestMapping("p_measure_check/find")//进入情况1.home.jsp中点击工序计量质检
public String turnToPMeasureCheck(ModelAndView mv, HttpSession session){
    List<String> sysPermissionList=new ArrayList<>();
    sysPermissionList.add("pMeasureCheck:add");//设置新建编辑删除按钮的显示
    sysPermissionList.add("pMeasureCheck:edit");
    sysPermissionList.add("pMeasureCheck:delete");
    session.setAttribute("sysPermissionList",sysPermissionList);
    return "p_measure_check_list";
}

    /**
     * 自动查询工序计量质检数据
     * @param page
     * @param rows
     * @return Object
     */
    @RequestMapping("p_measure_check/list")
    @ResponseBody
    public  Object findPagePMeasureCheck( int page, int rows){
        return erpService.findPMeasureCheck();
    }

    /**
     * 新建工序计量质检转入对应jsp
     * @return p_measure_check_add
     */
    @RequestMapping("p_measure_check/add")
    public String addPMeasureCheck(){
        return "p_measure_check_add";
    }

    /**
     * 工序计量质检判断
     * @return {}
     */
    @RequestMapping("pMeasureCheck/add_judge")
    @ResponseBody
    public String addJudgePMeasureCheck()  {
        return "{}";
    }

    /**
     * 新建工序计量质检记录
     * @param processMeasureCheck
     * @return map
     */
    @RequestMapping("p_measure_check/insert")
    @ResponseBody
    public Map<String,String > insertUnQualifyApply(ProcessMeasureCheck processMeasureCheck)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        erpService.addPMeasureCheckService(processMeasureCheck);
        return map;
    }

    /**
     * 修改工序计量质检记录判断
     * @return {}
     */
    @RequestMapping("pMeasureCheck/edit_judge")
    @ResponseBody
    public String editJudgePMeasureCheck()  {
        return "{}";
    }

    /**
     * 跳转修改工序计量质检页面
     * @return p_measure_check_edit
     */
    @RequestMapping("p_measure_check/edit")
    public String editPMeasureCheck(){
        return "p_measure_check_edit";
    }

    /**
     * 修改工序计量质检记录
     * @param processMeasureCheck
     * @return map
     */
    @RequestMapping("p_measure_check/update_all")
    @ResponseBody
    public Map<String,String > updatePMeasureCheck(ProcessMeasureCheck processMeasureCheck)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.updatePMeasureCheckService(processMeasureCheck);
        return map;
    }

    /**
     * 删除工序计量质检记录判断
     * @return {}
     */
    @RequestMapping("pMeasureCheck/delete_judge")//删除工序计量质检记录
    @ResponseBody
    public String deleteJudgePMeasureCheck()  {
        return "{}";
    }

    /**
     * 删除工序计量质检记录
     * @param ids
     * @return map
     */
    @RequestMapping("p_measure_check/delete_batch")
    @ResponseBody
    public Map<String,String > deletePMeasureCheck(String[] ids)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.deletePMeasureCheckService(ids);
        return map;
    }

    /**
     * 更新工序计量质检记录备注属性
     * @param pMeasureCheckId
     * @param note
     * @return map
     */
    @RequestMapping("p_measure_check/update_note")
    @ResponseBody
    public Map<String,String > updateNotePMeasureCheck(String pMeasureCheckId,String note)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.updateNotePMeasureCheckService(pMeasureCheckId,note);
        return map;
    }

    /**
     * 模糊查询成品计数质检记录
     * @param page
     * @param rows
     * @param searchname
     * @param searchValue
     * @return Object
     */
    @RequestMapping("p_measure_check/search_pMeasureCheck_by_{name}")
    @ResponseBody
    public Object findPageSearchPMeasureCheck(int page,int rows,@PathVariable("name") String searchname,String searchValue)  {
        return erpService.searchPMeasureCheckService(searchname,searchValue);
    }
/********************************工序计数质检模块******************************************************************/
    /**
     *
     * 跳转工序计数质检模块设置按钮显示
     * @param mv
     * @param session
     * @return
     */
    @RequestMapping("p_count_check/find")
public String turnToPCountCheck(ModelAndView mv, HttpSession session){
    List<String> sysPermissionList=new ArrayList<>();
    sysPermissionList.add("pCountCheck:add");
    sysPermissionList.add("pCountCheck:edit");
    sysPermissionList.add("pCountCheck:delete");
    session.setAttribute("sysPermissionList",sysPermissionList);
    return "p_count_check_list";
}

    /**
     * 自动查询工序计数质检数据
     * @param page
     * @param rows
     * @return Object
     */
    @RequestMapping("p_count_check/list")
    @ResponseBody
    public   Object findPagePCountCheck(int page, int rows){
        return erpService.findPCountCheckService();
    }

    /**
     * 新建工序计数质检转入对应jsp
     * @return p_count_check_add
     */
    @RequestMapping("p_count_check/add")
    public String addPCountCheck(){
        return "p_count_check_add";
    }

    /**
     * 工序质检判断
     * @return {}
     */
    @RequestMapping("pCountCheck/add_judge")
    @ResponseBody
    public String addJudgePCountCheck()  {
        return "{}";
    }

    /**
     * 新建工序计数质检记录
     * @param processCountCheck
     * @return map
     */
    @RequestMapping("p_count_check/insert")
    @ResponseBody
    public Map<String,String > insertPCountCheck(ProcessCountCheck processCountCheck)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        erpService.addPCountCheckService(processCountCheck);
        return map;
    }

    /**
     * 修改工序计数质检记录
     * @return {}
     */
    @RequestMapping("pCountCheck/edit_judge")
    @ResponseBody
    public String editJudgePCountCheck()  {
        return "{}";
    }

    /**
     * 跳转修改工序计数质检页面
     * @return p_count_check_edit
     */
    @RequestMapping("p_count_check/edit")
    public String editPCountCheck(){
        return "p_count_check_edit";
    }

    /**
     * 修改工序计数质检记录
     * @param processCountCheck
     * @return map
     */
    @RequestMapping("p_count_check/update_all")
    @ResponseBody
    public Map<String,String > updatePCountCheck(ProcessCountCheck processCountCheck)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.updatePCountCheckService(processCountCheck);
        return map;
    }

    /**
     * 删除工序计数质检记录判断
     * @return {}
     */
    @RequestMapping("pCountCheck/delete_judge")
    @ResponseBody
    public String deleteJudgePCountCheck()  {
        return "{}";
    }

    /**
     * 删除工序计数质检记录
     * @param ids
     * @return
     */
    @RequestMapping("p_count_check/delete_batch")
    @ResponseBody
    public Map<String,String > deletePCountCheck(String[] ids)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.deletePCountCheckService(ids);
        return map;
    }

    /**
     * 更新工序计数质检记录备注属性
     * @param pCountCheckId
     * @param note
     * @return
     */
    @RequestMapping("p_count_check/update_note")
    @ResponseBody
    public Map<String,String > updateNotePCountCheck(String pCountCheckId,String note)  {
        Map<String,String > map = new HashMap<>();
        map.put("status","200");
        map.put("msg","OK");
        int i = erpService.updateNotePCountCheckService(pCountCheckId,note);
        return map;
    }

    /**
     * 模糊查询成品计数质检记录
     * @param page
     * @param rows
     * @param searchname
     * @param searchValue
     * @return Object
     */
    @RequestMapping("p_count_check/search_pCountCheck_by_{name}")
    @ResponseBody
    public Object findPageSearchPCountCheck(int page,int rows,@PathVariable("name") String searchname,String searchValue)  {
        return erpService.searchPCountCheckService(searchname,searchValue);
    }
}
