package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.model.*;
import com.cskaoyan.erp.service.ErpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
    @Autowired
    private ErpService erpService;

    /*****************Order控制层*************************************/


    @RequestMapping("order/find")
    public String toOrderList(HttpSession session) {
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("order:add");
        sysPermissionList.add("order:edit");
        sysPermissionList.add("order:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "order_list";
    }

    @ResponseBody
    @RequestMapping("order/list")
    public List<COrder> findOrder() {
        return erpService.findCOrder();
    }

    @RequestMapping("order/get/{id}")
    @ResponseBody
    public COrder getOrder(@PathVariable("id") String id) {
        return erpService.findCOrderById(id);
    }

    /**
     * 添加Order的controller
     */
    @RequestMapping("order/add_judge")
    @ResponseBody
    public Map<String, String> addOrderJudge(COrder cOrder) {
        return new HashMap<>();
    }

    @RequestMapping("order/add")
    public String addOrder() {
        return "order_add";
    }

    @RequestMapping("order/insert")
    @ResponseBody
    public Map<String, String> insertOrder(COrder cOrder) {
        int i = erpService.addOrder(cOrder);
        return getStatusMap(i);
    }


    /**
     * 编辑Order的controller
     */
    @RequestMapping("order/edit_judge")
    @ResponseBody
    public Map<String, String> editOrderJudge(COrder cOrder) {
        return new HashMap<>();
    }

    @RequestMapping("order/edit")
    public String editOrder() {
        return "order_edit";
    }

    @RequestMapping("order/update_all")
    @ResponseBody
    public Map<String, String> updateOrder(COrder cOrder) {
        int i = erpService.editOrder(cOrder);
        return getStatusMap(i);
    }


    /**
     * 删除Order的controller
     */
    @RequestMapping("order/delete_judge")
    @ResponseBody
    public Map<String, String> deleteCustomJudge(COrder cOrder) {
        return new HashMap<>();
    }

    @RequestMapping("order/delete_batch")
    @ResponseBody
    public Map<String, String> deleteOrderBatch(String[] ids) {
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        int i = erpService.deleteOrder(ids);

        if (i != ids.length) {
            map.put("msg", "异常");
        }
        return map;
    }



    /*****************Custom控制层*************************************/
    /**
     * 查找Custom的controller
     */
    @RequestMapping("custom/find")
    public String toCustomList(HttpSession session) {
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("custom:add");
        sysPermissionList.add("custom:edit");
        sysPermissionList.add("custom:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "custom_list";
    }

    @RequestMapping("custom/get/{id}")
    @ResponseBody
    public Custom getCustom(@PathVariable("id") String id) {
        return erpService.findCustomById(id);
    }

    @ResponseBody
    @RequestMapping("custom/list")
    public List<Custom> findCustom() {
        return erpService.findCustom();
    }

    @RequestMapping("custom/get_data")
    @ResponseBody
    public List<Custom> getCustomData() {
        return erpService.findCustom();
    }


    /**
     * 添加Custom的controller
     */
    @RequestMapping("custom/add_judge")
    @ResponseBody
    public Map<String, String> addCustomJudge(Custom custom) {
        return new HashMap<>();
    }

    @RequestMapping("custom/add")
    public String addCustom() {
        return "custom_add";
    }

    @RequestMapping("custom/insert")
    @ResponseBody
    public Map<String, String> insertCustom(Custom custom) {
        int i = erpService.addCustom(custom);
        return getStatusMap(i);
    }

    private Map<String, String> getStatusMap(int i) {
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        if (i != 1) {
            map.put("msg", "异常");
        }
        return map;
    }

    /**
     * 编辑Custom的controller
     */
    @RequestMapping("custom/edit_judge")
    @ResponseBody
    public Map<String, String> editCustomJudge(Custom custom) {
        return new HashMap<>();
    }

    @RequestMapping("custom/edit")
    public String editCustom() {
        return "custom_edit";
    }

    @RequestMapping("custom/update_all")
    @ResponseBody
    public Map<String, String> updateCustom(Custom custom) {
        int i = erpService.editCustom(custom);
        return getStatusMap(i);
    }


    /**
     * 删除Custom的controller
     */
    @RequestMapping("custom/delete_judge")
    @ResponseBody
    public Map<String, String> deleteCustomJudge(Custom custom) {
        return new HashMap<>();
    }

    @RequestMapping("custom/delete_batch")
    @ResponseBody
    public Map<String, String> deleteCustomBatch(String[] ids) {
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        int i = erpService.deleteCustom(ids);

        if (i != ids.length) {
            map.put("msg", "异常");
        }
        return map;
    }

    /*****************Product控制层*************************************/

    @RequestMapping("product/find")
    public String toProductList(HttpSession session) {
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("product:add");
        sysPermissionList.add("product:edit");
        sysPermissionList.add("product:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "product_list";
    }

    @RequestMapping("product/get/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable("id") String id) {

        return erpService.findProductById(id);
    }

    @RequestMapping("product/list")
    @ResponseBody
    public List<Product> findProduct() {
        return erpService.findProduct();
    }


    /**
     * 添加商品的controller
     */
    @RequestMapping("product/add_judge")
    @ResponseBody
    public Map<String, String> addProductJudge(Product product) {
        return new HashMap<>();
    }

    @RequestMapping("product/add")
    public String addProduct() {
        return "product_add";
    }

    @RequestMapping("product/insert")
    @ResponseBody
    public Map<String, String> insertProduct(Product product) {
        int i = erpService.addProduct(product);
        Map<String, String> map = getStatusMap(i);
        return map;
    }

    /**
     * 编辑商品的controller
     */
    @RequestMapping("product/edit_judge")
    @ResponseBody
    public Map<String, String> editProductJudge(Product product) {
        return new HashMap<>();
         /*  if(product == null || product.getProductId() == null) {
            map.put("msg", "产品信息异常");
        }*/
    }

    @RequestMapping("product/edit")
    public String editProduct() {
        return "product_edit";
    }

    @RequestMapping("product/update_all")
    @ResponseBody
    public Map<String, String> updateProduct(Product product) {
        int i = erpService.editProduct(product);
        return getStatusMap(i );
    }


    /**
     * 删除商品的controller
     */
    @RequestMapping("product/delete_judge")
    @ResponseBody
    public Map<String, String> deleteProductJudge(Product product) {
        return new HashMap<>();
         /*  if(product == null || product.getProductId() == null) {
            map.put("msg", "产品信息异常");
        }*/
    }

    @RequestMapping("product/delete_batch")
    @ResponseBody
    public Map<String, String> deleteProductBatch(String[] ids) {
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        int i = erpService.deleteProduct(ids);
        if(i != ids.length) {
            map.put("msg", "删除异常");
        }
        return map;
    }

    @RequestMapping("product/get_data")
    @ResponseBody
    public List<Product> getProductData() {
        return erpService.findProduct();
    }

    /*****************Work控制层*************************************/

    @RequestMapping("work/find")
    public String toWorkList(HttpSession session) {
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("work:add");
        sysPermissionList.add("work:edit");
        sysPermissionList.add("work:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "work_list";
    }

    @RequestMapping("work/list")
    @ResponseBody
    public List<Work> findWork() {
        return erpService.findWork();
    }

    @RequestMapping("work/get/{id}")
    @ResponseBody
    public Product getWork(@PathVariable("id") String id) {

        return erpService.findWorkById(id);
    }

    /*****************Manufacture控制层*************************************/
    @RequestMapping("manufacture/find")
    public String toManufactureList(HttpSession session) {
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("manufacture:add");
        sysPermissionList.add("manufacture:edit");
        sysPermissionList.add("manufacture:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "manufacture_list";
    }

    @RequestMapping("manufacture/list")
    @ResponseBody
    public List<Manufacture> findManufacture() {
        return erpService.findManufacture();
    }


    /*****************Task控制层*************************************/
    /**
     * 查找Task的controller
     */
    @RequestMapping("task/find")
    public String toTaskList(HttpSession session) {
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("task:add");
        sysPermissionList.add("task:edit");
        sysPermissionList.add("task:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "task_list";
    }

    @ResponseBody
    @RequestMapping("task/list")
    public List<Task> findTask() {
        return erpService.findTask();
    }

    @RequestMapping("task/get/{id}")
    @ResponseBody
    public Task getTask(@PathVariable("id") String id) {
        return erpService.findTaskById(id);
    }

    /**
     * 添加Task的controller
     */
    @RequestMapping("task/add_judge")
    @ResponseBody
    public Map<String, String> addTaskJudge(Task task) {
        return new HashMap<>();
    }

    @RequestMapping("task/add")
    public String addTask() {
        return "task_add";
    }

    @RequestMapping("task/insert")
    @ResponseBody
    public Map<String, String> insertOrder(Task task) {
        int i = erpService.addTask(task);
        return getStatusMap(i);
    }


    /**
     * 编辑Task的controller
     */
    @RequestMapping("task/edit_judge")
    @ResponseBody
    public Map<String, String> editOrderJudge(Task task) {
        return new HashMap<>();
    }

    @RequestMapping("task/edit")
    public String editTask() {
        return "task_edit";
    }

    @RequestMapping("task/update_all")
    @ResponseBody
    public Map<String, String> updateTask(Task task) {
        int i = erpService.editTask(task);
        return getStatusMap(i);
    }


    /**
     * 删除Task的controller
     */
    @RequestMapping("task/delete_judge")
    @ResponseBody
    public Map<String, String> deleteTaskJudge(Task task) {
        return new HashMap<>();
    }

    @RequestMapping("task/delete_batch")
    @ResponseBody
    public Map<String, String> deleteTaskBatch(String[] ids) {
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        int i = erpService.deleteTask(ids);

        if (i != ids.length) {
            map.put("msg", "异常");
        }
        return map;
    }

}
