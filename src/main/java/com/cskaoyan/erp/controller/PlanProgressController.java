package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.model.COrder;
import com.cskaoyan.erp.model.Custom;
import com.cskaoyan.erp.model.Product;
import com.cskaoyan.erp.service.ErpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * 计划进度的Controller
 */
@Controller
public class PlanProgressController {


    /*****************订单curd控制层*************************************/
    @Autowired
    private ErpService erpService;

    @RequestMapping("order/find")
    public String toOrderList(HttpSession session){
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("order:add");
        sysPermissionList.add("order:edit");
        sysPermissionList.add("order:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "order_list";
    }

    @ResponseBody
    @RequestMapping("order/list")
    public List<COrder> findOrder(){
        List<COrder> cOrder = erpService.findCOrder();
        System.out.println(cOrder);
        return cOrder;
    }


    /*****************客户curd控制层*************************************/


    @RequestMapping("custom/find")
    public String toCustomList(HttpSession session){
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("custom:add");
        sysPermissionList.add("custom:edit");
        sysPermissionList.add("custom:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "custom_list";
    }

    @ResponseBody
    @RequestMapping("custom/list")
    public List<Custom> findCustom(){
        return erpService.findCustom();
    }

    /*****************产品curd控制层*************************************/

    @RequestMapping("product/find")
    public String toProductList(HttpSession session){
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("product=:add");
        sysPermissionList.add("product:edit");
        sysPermissionList.add("product:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "product_list";
    }

    @RequestMapping("/product/list")
    protected @ResponseBody List<Product> findProduct(){
        return erpService.findProduct();
    }
}
