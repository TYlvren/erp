package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.dao.ProcessDao;
import com.cskaoyan.erp.model.*;
import com.cskaoyan.erp.model.Process;
import com.cskaoyan.erp.service.ErpService;
import net.sf.json.JSONObject;
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
    public String findMaterial(HttpSession httpSession) {
        List<String> sysPermissionList = (ArrayList<String>) httpSession.getAttribute("sysPermissionList");
        if (sysPermissionList == null) {
            sysPermissionList = new ArrayList<>();
        }
        if (!sysPermissionList.contains("material:add")) {
            sysPermissionList.add("material:add");
            sysPermissionList.add("material:edit");
            sysPermissionList.add("material:delete");
            httpSession.setAttribute("sysPermissionList", sysPermissionList);
        }
        return "material_list";
    }

    @RequestMapping("material/list")
    @ResponseBody
    public Object findPageMaterial(@RequestParam int page, int rows)  {

        List<Material> materialList = erpService.selectMaterial();
       return materialList;

    }

    @RequestMapping("material/search_material_by_{name}")
    @ResponseBody
    public Map<String, Object> search(String searchValue, @PathVariable("name") String name, @RequestParam("page") Integer pageNum, @RequestParam("rows") Integer pageSize){
        Map<String, Object> map = null;
        if("materialId".equals(name)) {

            map=  erpService.selectMaterialById(searchValue,pageNum, pageSize);
        }
        if("materialType".equals(name)) {
            map = erpService.selectMaterialByType(searchValue,pageNum,pageSize);
        }
        return map;
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
        Map<String, String> map = new HashMap<>();
        erpService.addMaterial(material);
        map.put("status", "200");
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
    public String removeMaterial(String ids, HttpServletRequest request) {
        String[] split = ids.split(",");
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
    public String updateMaterialById(Material material) {
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
    public String findMaterialReceive(HttpSession session) {
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("materialReceive:add");
        sysPermissionList.add("materialReceive:edit");
        sysPermissionList.add("materialReceive:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "materialReceive_list";
    }

    @RequestMapping("materialReceive/list")
    @ResponseBody
    public Map<String, Object> materialReceiveLsit(@RequestParam("page") Integer pageNum, @RequestParam("rows") Integer pageSize){
        Map<String, Object> map=  erpService.listMaterialReceiveByPage(pageNum, pageSize);
        return map;
    }



    @RequestMapping("materialReceive/add_judge")
    public String addMaterialReceive() {
        return "materialReceive_add";
    }
    @RequestMapping("material/get_data")
    @ResponseBody
    public List<Material> getMaterialId() {
        List<Material> materialList= erpService.selectMaterialId();
        return materialList;
    }
    @RequestMapping("materialReceive/add")
    public String addMaterialReceive2() {
        return "materialReceive_add";
    }

    @RequestMapping("materialReceive/insert")
    public String addMaterialReceive(MaterialReceive materialReceive) {
        System.out.println("materialReceive:" + materialReceive);
        erpService.addMaterialReceive(materialReceive);
        return "materialReceive_add";
    }
    @RequestMapping("materialReceive/edit_judge")
    public String updateMaterialReceive() {
        return "materialReceive_edit";
    }

    @RequestMapping("materialReceive/edit")
    public String updateMaterialReceive2() {
        return "materialReceive_edit";
    }

    @RequestMapping("materialReceive/update_all")
    public String updateReceiveById(MaterialReceive materialReceive) {
        //System.out.println("update");
        System.out.println(materialReceive);
        erpService.modifyMaterialReceive(materialReceive);
        return "materialReceive_edit";
    }

    @RequestMapping("materialReceive/update_note")
    public String updateReceiveNote(MaterialReceive materialReceive) {
        //System.out.println("update");
        System.out.println(materialReceive);
        erpService.modifyReceiveNote(materialReceive);
        return "materialReceive_edit";
    }
    @RequestMapping("materialReceive/delete_judge")
    public String deleteReceive() {
        return "materialReceive_list";
    }

    @RequestMapping("materialReceive/delete_batch")
    public String removeReceive(String ids) {
        String[] split = ids.split(",");
        System.out.println(split);
        for (String s : split) {
            erpService.removeMaterialReceiveById(s);
        }

        return "materialReceive_list";
    }
    @RequestMapping("materialReceive/search_materialReceive_by_{name}")
    @ResponseBody
    public Map<String, Object> searchReceive(String searchValue, @PathVariable("name") String name, @RequestParam("page") Integer pageNum, @RequestParam("rows") Integer pageSize){
        Map<String, Object> map = null;
        if("materialId".equals(name)) {

            map=  erpService.searchMaterialReceiveBymaterialId(searchValue,pageNum, pageSize);
        }
        if("receiveId".equals(name)) {
            map = erpService.searchMaterialReceiveByReceiveId(searchValue,pageNum,pageSize);
        }
        return map;
    }

    /*---------物料消耗模块------------------------------------------------------------------------*/
    @RequestMapping("materialConsume/find")//进入物料收入信息
    public String findMaterialConsume(HttpSession session) {
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("materialConsume:add");
        sysPermissionList.add("materialConsume:edit");
        sysPermissionList.add("materialConsume:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "materialConsume_list";
    }
    @RequestMapping("materialConsume/add_judge")
    public String addMaterialConsume() {
        return "materialConsume_add";
    }
    @RequestMapping("materialConsume/add")
    public String addMaterialConsume2() {
        return "materialConsume_add";
    }
    @RequestMapping("materialConsume/insert")
    public String addMaterialConsume(MaterialConsume materialConsume) {
        System.out.println("materialConsume:" + materialConsume);
        erpService.addMaterialConsume(materialConsume);
        return "materialConsume_add";
    }
    @RequestMapping("materialConsume/list")
    @ResponseBody
    public Map<String, Object> materialConsumeList(@RequestParam("page") Integer pageNum, @RequestParam("rows") Integer pageSize){
        Map<String, Object> map=  erpService.listMaterialConsumeByPage(pageNum, pageSize);
        return map;
    }
    @RequestMapping("materialConsume/search_materialConsume_by_{name}")
    @ResponseBody
    public Map<String, Object> searchConsume(String searchValue, @PathVariable("name") String name, @RequestParam("page") Integer pageNum, @RequestParam("rows") Integer pageSize){
        Map<String, Object> map = null;
        if("consumeId".equals(name)) {

            map=  erpService.searchMaterialConsumeByConsumeId(searchValue,pageNum, pageSize);
        }
        if("workId".equals(name)) {
            map = erpService.searchMaterialConsumeByWorkId(searchValue,pageNum,pageSize);
        }
        if("materialId".equals(name)) {
            map = erpService.searchMaterialConsumeBymaterialId(searchValue,pageNum,pageSize);
        }
        return map;
    }
    @RequestMapping("materialConsume/edit_judge")
    public String updateMaterialConsume() {
        return "materialConsume_edit";
    }

    @RequestMapping("materialConsume/edit")
    public String updateMaterialConsume2() {
        return "materialConsume_edit";
    }
    @RequestMapping("materialConsume/update_all")
    public String updateConsumeById(MaterialConsume materialConsume) {
        //System.out.println("update");
        System.out.println(materialConsume);
        erpService.modifyMaterialConsume(materialConsume);
        return "materialConsume_edit";
    }

    @RequestMapping("materialConsume/update_note")
    public String updateReceiveNote(MaterialConsume materialConsume) {
        erpService.modifyConsumeNote(materialConsume);
        return "materialConsume_edit";
    }
    @RequestMapping("materialConsume/delete_judge")
    public String deleteConsume() {
        return "materialConsume_list";
    }

    @RequestMapping("materialConsume/delete_batch")
    public String removeConsume(String ids) {
        String[] split = ids.split(",");
        System.out.println(split);
        for (String s : split) {
            erpService.removeMaterialConsumeById(s);
        }

        return "materialConsume_list";
    }

}