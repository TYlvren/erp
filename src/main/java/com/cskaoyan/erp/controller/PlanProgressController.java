package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.model.COrder;
import com.cskaoyan.erp.model.Custom;
import com.cskaoyan.erp.model.Product;
import com.cskaoyan.erp.service.ErpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @RequestMapping("custom/get/{id}")
    @ResponseBody
    public Custom getCustom(@PathVariable("id") String id){
        return erpService.findCustomById(id);
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
        sysPermissionList.add("product:add");
        sysPermissionList.add("product:edit");
        sysPermissionList.add("product:delete");
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "product_list";
    }

    @RequestMapping("product/get/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable("id") String id){

        return erpService.findProductByid(id);
    }

    @RequestMapping("product/list")
    @ResponseBody
    public List<Product> findProduct(){
        return erpService.findProduct();
    }


    /**  添加商品的controller */
    @RequestMapping("product/add_judge")
    @ResponseBody
    public Map<String,String> addProductJudge(Product product){
        return new HashMap<>();
    }

    @RequestMapping("product/add")
    public String addProduct(){
        return "product_add";
    }

    @RequestMapping("product/insert")
    @ResponseBody
    public Map<String,String> insertProduct(Product product){
        int i = erpService.addProduct(product);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        if(i != 1) {
            map.put("msg", "添加异常");
        }
        return map;
    }

    /** 编辑商品的controller */
    @RequestMapping("product/edit_judge")
    @ResponseBody
    public Map<String,String> editProductJudge(Product product){
        return new HashMap<>();
         /*  if(product == null || product.getProductId() == null) {
            map.put("msg", "产品信息异常");
        }*/
    }

    @RequestMapping("product/edit")
    public String editProduct(){
        return "product_edit";
    }

    @RequestMapping("product/update_all")
    @ResponseBody
    public Map<String,String> updateProduct(Product product){
        int i = erpService.editProduct(product);
        Map<String,String> map = new HashMap<>();
        map.put("status","200");
        if(i != 1) {
            map.put("msg", "更新异常");
        }
        return map;
    }


    /**
     * 质量监控需要的查询全部product的接口
     */
    @RequestMapping("product/get_data")
    @ResponseBody
    public List<Product> getProductData(){
        return erpService.findProduct();
    }
}
