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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public String findUnqualify(ModelAndView mv){
        List<UnQualifyApply> unqualifyList = erpService.findUnqualifyList();
        mv.addObject("unqualifyList",unqualifyList);
        return "unqualify_list";
    }
}
