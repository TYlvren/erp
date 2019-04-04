package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.model.Material;
import com.cskaoyan.erp.model.MaterialReceive;
import com.cskaoyan.erp.service.ErpService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MaterialController {
    @Autowired
    @Qualifier("erpService")
    private ErpService erpService;
    /*---------物料信息模块------------------------------------------------------------------------*/

    /**
     * 处理查询请求
     *
     * @param
     * @param
     * @param
     */
    @RequestMapping("material/find")//进入物料信息
    public String findMaterial(HttpSession session) {
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("material:add");
        sysPermissionList.add("material:edit");
        sysPermissionList.add("material:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "material_list";
    }

    @RequestMapping("material/list")
    public void selectMaterial(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        List<Material> materialList = erpService.selectMaterial();
        int total = erpService.selectCountOfMaterial();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("total", total);
        hashMap.put("rows", materialList);
        JSONObject jsonObject = JSONObject.fromObject(hashMap);
        response.getWriter().println(jsonObject);

    }

    @RequestMapping("material/search_material_by_{name}")
    @ResponseBody
    public void search(String searchValue, @PathVariable("name") String name, HttpServletResponse response) throws IOException {
        if ("materialId".equals(name)) {
            Map<String, Object> map = null;
            response.setContentType("text/html;charset=utf-8");
            List<Material> materialList = erpService.selectMaterialById(searchValue);
            int total = erpService.selectCountOfMaterial();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("total", total);
            hashMap.put("rows", materialList);
            JSONObject jsonObject = JSONObject.fromObject(hashMap);
            response.getWriter().println(jsonObject);
        }
        if ("materialType".equals(name)) {
            Map<String, Object> map = null;
            response.setContentType("text/html;charset=utf-8");
            List<Material> materialList = erpService.selectMaterialByType(searchValue);
            int total = erpService.selectCountOfMaterial();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("total", total);
            hashMap.put("rows", materialList);
            JSONObject jsonObject = JSONObject.fromObject(hashMap);
            response.getWriter().println(jsonObject);
        }

    }





    /**
     * 处理添加请求
     *
     * @param
     * @param
     * @param
     */
    @RequestMapping("material/add_judge")
    public String addMaterial() {
        return "material_add";
    }

    @RequestMapping("material/add")
    public String addMaterial2() {
        return "material_add";
    }

    @RequestMapping("material/insert")
    public String addMaterial(Material material) {
        System.out.println("material:" + material);
        erpService.addMaterial(material);
        return "material_add";
    }
    /**
     * 处理删除请求
     *
     * @param
     * @param
     * @param
     */
    @RequestMapping("material/delete_judge")
    public String deleteMaterial() {
        return "material_list";
    }

    @RequestMapping("material/delete_batch")
    public String removeMaterial(String ids,HttpServletRequest request) {
        String[] split = ids.split(",");
        System.out.println(split);
        for (String s : split) {
            erpService.removeMaterialById(s);
        }

        return "material_list";
    }
    /**
     * 处理修改请求
     *
     * @param
     * @param
     * @param
     */
    @RequestMapping("material/edit_judge")
    public String updateMaterial() {
        return "material_edit";
    }
    @RequestMapping("material/edit")
    public String updateMaterial2() {
        return "material_edit";
    }

    @RequestMapping("material/update_all")
    public String updateUserById(Material material) {
        //System.out.println("update");
            System.out.println(material);
            erpService.modifyMaterial(material);
            return "material_edit";
        }
    @RequestMapping("material/update_note")
    public String updateNote(Material material) {
        //System.out.println("update");
        System.out.println(material);
        erpService.modifyNote(material);
        return "material_edit";
    }

        /*---------物料收入模块------------------------------------------------------------------------*/
   @RequestMapping("materialReceive/find")//进入物料收入信息
    public String findMaterialReceive(HttpSession session){
       List<String> sysPermissionList = new ArrayList<>();
       sysPermissionList.add("materialReceive:add");
       sysPermissionList.add("materialReceive:edit");
       sysPermissionList.add("materialReceive:delete");
       session.setAttribute("sysPermissionList", sysPermissionList);
        return "materialReceive_list";
    }
    @RequestMapping("materialReceive/list")
    public void selectMaterialReceive( HttpServletResponse response,HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        List<MaterialReceive> materialReceiveList = erpService.selectMaterialReceive();
        int total=erpService.selectCountOfMaterialReceive();
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("total",total);
        hashMap.put("rows",materialReceiveList);
        JSONObject jsonObject= JSONObject.fromObject(hashMap);
        response.getWriter().println(jsonObject);

    }
    }
    /*---------物料消耗模块------------------------------------------------------------------------*/

