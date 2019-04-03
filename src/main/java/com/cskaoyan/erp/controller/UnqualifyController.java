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
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @RequestMapping("list")//自动查询数据
    public  @ResponseBody List<UnQualifyApply> findUnqualify(int page, int rows){
        List<UnQualifyApply> unqualifyList = erpService.findUnqualifyList();
        return unqualifyList;
    }
    @RequestMapping("add")//新建不合格品记录
    public String addUniqualify(){
        //erpService.addUnqualifyService(unQualifyApply);
        //UnQualifyApply unQualifyApply
        //return "unqualify_list";
       return "unqualify_add";
    }
    @RequestMapping("add_judge")//新建不合格品记录
    @ResponseBody
    public String addJudgeUniqualify()  {
        return "{}";
    }

    @RequestMapping("insert")//新建不合格品记录
    @ResponseBody
    public String insertUnQualifyApply(@RequestBody UnQualifyApply unQualifyApply)  {
        erpService.addUnqualifyService(unQualifyApply);
        return "{}";
    }
}
