package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.dao.ProcessDao;
import com.cskaoyan.erp.dao.TechnologyDao;
import com.cskaoyan.erp.dao.TechnologyPlanDao;
import com.cskaoyan.erp.dao.TechnologyRequirementDao;
import com.cskaoyan.erp.model.*;
import com.cskaoyan.erp.model.Process;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class TechnologyController {
    @Autowired
    TechnologyDao technologyDao;

    //模块一
    /********************工艺管理**********************/

    //工艺查询操作
    @RequestMapping("technology/find")
    public String testcase01(){
        return "technology_list";
    }

    @RequestMapping("technology/list")
    @ResponseBody
    public Map testcase02(@RequestParam int page, int rows){
        PageHelper.startPage(page, rows);
        List<Technology> technologyList = technologyDao.selectTechnology();
        int total = technologyDao.selectCountOfTechnology();
        PageInfo pageInfo = new PageInfo(technologyList);
        technologyList = pageInfo.getList();
        Map<String,Object > hashMap = new HashMap();
        hashMap.put("total",total);
        hashMap.put("rows",technologyList);
        return hashMap;
    }
    //工艺的添加操作
    @RequestMapping("technology/add_judge")
    public String testcase03(){
        return "technology_add";
    }
    @RequestMapping("technology/add")
    public String testcase04(){
        return "technology_add";
    }

    @RequestMapping("technology/insert")
    @ResponseBody
    public Map<String,String> testcase05(Technology technology){
        //检查工艺名或工艺号是否已存在
        List<Technology> technologyList = technologyDao.selectTechnologyNameAndIDisExist(
                technology.getTechnologyId(),technology.getTechnologyName());
        Map<String,String> map = new HashMap<>();
        if (technologyList.isEmpty()){
            technologyDao.insertTechnology(technology);
            map.put("status", "200");
        }else {
            map.put("msg", "添加异常");
        }
        return map;
    }

    //工艺的删除操作
    @RequestMapping("technology/delete_judge")
    public String testcase06(HttpServletRequest request){
        return "technology_list";
    }

    @RequestMapping("technology/delete_batch")
    @ResponseBody
    public Map<String,String> testcase07(@RequestParam String ids){
        Map<String,String> map = new HashMap<>();
        String[] str = ids.split(",");
        for (int i = 0; i < str.length; i++) {
            String tid = str[i];
            technologyDao.removeTechnologyById(tid);
        }
        map.put("status", "200");
        return map;
    }

    //工艺更新操作
    @RequestMapping("technology/edit_judge")
    public String testcase08(){
        return "technology_edit";
    }

    @RequestMapping("technology/edit")
    public String testcase09(Technology technology){
        return "technology_edit";
    }

    @RequestMapping("technology/update_all")
    @ResponseBody
    public Map<String,String> testcase10(Technology technology){
        //获取修改后的技术信息，对其进行修改

        Technology technology1 =
                technologyDao.selectTechnologyNameisExist(technology.getTechnologyName());
        Map<String,String> map = new HashMap<>();
        if (technology1 == null){
            technologyDao.updateTechnology(technology);
            map.put("status", "200");
        }else {
            map.put("msg","错了兄弟");
        }
        return map;
    }
    //工艺的信息显示操作custom/get/{id}
    @RequestMapping("technology/get/{id}")
    @ResponseBody
    public Technology testcase(@PathVariable("id") String id){
        Technology technologyById = technologyDao.findTechnologyById(id);
        return technologyById;
    }

    //模块二
    /********************工艺要求**********************/
    @Autowired
    TechnologyRequirementDao requirementDao;

    //查询所有的工艺要求信息
    @RequestMapping("technologyRequirement/find")
    public String testcase11(){
        return "technologyRequirement_list";
    }
    @RequestMapping("technologyRequirement/list")
    @ResponseBody
    public Map testcase12(@RequestParam int page, int rows){
        PageHelper.startPage(page, rows, true);
        List<TechnologyRequirement> technologyRequirements = requirementDao.selectTechnologyRequirement();
        for (TechnologyRequirement t :technologyRequirements
             ) {
            t.setTechnologyName(t.getTechnology().getTechnologyName());
            t.setTechnologyId(t.getTechnology().getTechnologyId());
        }
        PageInfo pageInfo = new PageInfo(technologyRequirements);
        technologyRequirements = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", technologyRequirements);
        return map;
    }

    //新增技艺的参数信息
    @RequestMapping("technologyRequirement/add_judge")
    public String testcase14(){
        return "technologyRequirement_add";
    }

    @RequestMapping("technologyRequirement/add")
    public String testcase15(){
        return "technologyRequirement_add";
    }

    @RequestMapping("technologyRequirement/get_data")
    @ResponseBody
    public List<Technology> testcase16(){
        List<Technology> technologies = technologyDao.selectTechnology();
        return technologies;
    }

    @RequestMapping("technologyRequirement/insert")
    @ResponseBody
    public Map<String, String> testcase17(TechnologyRequirement technologyRequirement){
        Map<String, String> map = new HashMap<>();
        //首先判断输入的工艺要求编号是否重复
        String technologyRequirementId = technologyRequirement.getTechnologyRequirementId();
        TechnologyRequirement requirement =
                requirementDao.technologyRequirementIdIsexist(technologyRequirementId);
        if (requirement == null){
            requirementDao.addTechnologyRequirement(technologyRequirement);
            map.put("status", "200");
            return map;
        }else {
            map.put("msg", "工艺要求编号已存在，请重新输入");
            return map;
        }
    }

    //删除选中的信息
    @RequestMapping("technologyRequirement/delete_judge")
    public String testcase21(){
        return "technologyRequirement_list";
    }

    @RequestMapping("technologyRequirement/delete_batch")
    @ResponseBody
    public Map<String, String> testcase22(String[] ids){
        for (int i = 0; i < ids.length; i++) {
            String tid = ids[i];
            requirementDao.removeTechnologyRequirementById(tid);
        }
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        return map;
    }

    //工艺要求的编辑功能
    @RequestMapping("technologyRequirement/edit_judge")
    public String testcase23(){
        return "technologyRequirement_edit";
    }

    @RequestMapping("technologyRequirement/edit")
    public String testcase24(){
        return "technologyRequirement_edit";
    }

    @RequestMapping("technologyRequirement/update_all")
    @ResponseBody
    public Map<String, String> testcase25(TechnologyRequirement technologyRequirement){

        int i = requirementDao.updateTechnology(technologyRequirement);
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        return map;
    }

    /********************工艺计划模块***************/
    @Autowired
    TechnologyPlanDao technologyPlanDao;

    //查询工艺计划列表
    @RequestMapping("technologyPlan/find")
    public String testcase26(){
        return "technologyPlan_list";
    }

    @RequestMapping("technologyPlan/list")
    @ResponseBody
    public Map<String, Object> testcase27(@RequestParam int page, int rows){
        PageHelper.startPage(page, rows);
        Map<String,Object > hashMap = new HashMap();
        List<TechnologyPlan> technologyPlans =
                technologyPlanDao.selectTechnologyPlan();
        PageInfo pageInfo = new PageInfo(technologyPlans);
        long total = pageInfo.getTotal();
        for (TechnologyPlan t :technologyPlans
        ) {
            t.setTechnologyName(t.getTechnology().getTechnologyName());
            t.setTechnologyId(t.getTechnology().getTechnologyId());
        }
        hashMap.put("total",total);
        hashMap.put("rows",technologyPlans);
        return hashMap;
    }

    //新增工艺计划
    @RequestMapping("technologyPlan/add_judge")
    public String testcase27(){
        return "technologyPlan_add";
    }

    @RequestMapping("technologyPlan/add")
    public String testcase28(){
        return "technologyPlan_add";
    }

    @RequestMapping("technology/get_data")
    @ResponseBody
    public List<Technology> testcase29(){
        List<Technology> technologies = technologyDao.selectTechnology();
        return technologies;
    }

    @RequestMapping("technologyPlan/insert")
    @ResponseBody
    public Map<String, String> testcase30(TechnologyPlan technologyPlan){
        Map<String, String> map = new HashMap<>();
        //首先判断输入的工艺要求编号是否重复
        String technologyPlanId = technologyPlan.getTechnologyPlanId();

        List<TechnologyPlan> technologyPlan1 =
                technologyPlanDao.technologyPlanIdIsexist(technologyPlanId);

        if (technologyPlan1.isEmpty()){
            technologyPlanDao.addTechnologyPlan(technologyPlan);
            map.put("status", "200");
            return map;
        }else {
            map.put("msg", "工艺计划编号已存在，请重新输入");
            return map;
        }
    }

    //删除数据
    @RequestMapping("technologyPlan/delete_judge")
    public String testcase31(){
        return "technologyPlan_list";
    }

    @RequestMapping("technologyPlan/delete_batch")
    @ResponseBody
    public Map<String, String> testcase32(String[] ids, HttpServletRequest request){
        for (int i = 0; i < ids.length; i++) {
            String tid = ids[i];
            technologyPlanDao.removeTechnologyPlanById(tid);
        }
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        return map;
    }

    //更新数据
    @RequestMapping("technologyPlan/edit_judge")
    public String testcase33(){
        return "technologyPlan_edit";
    }

    @RequestMapping("technologyPlan/edit")
    public String testcase34(){
        return "technologyPlan_edit";
    }

    @RequestMapping("technologyPlan/update_all")
    @ResponseBody
    public Map<String, String> testcase35(TechnologyPlan TechnologyPlan){
        int i = technologyPlanDao.updateTechnologyPlan(TechnologyPlan);
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        return map;
    }

    @RequestMapping("technologyPlan/get_data")
    @ResponseBody
    public List<TechnologyPlan> testcase47(){
        List<TechnologyPlan> technologyPlans = technologyPlanDao.selectTechnologyPlan();
        return technologyPlans;
    }


    /******************工序模块*******************/

    @Autowired
    ProcessDao processDao;

    //查询所有的工序信息
    @RequestMapping("process/find")
    public String testcase18(HttpServletResponse response){
        return "process_list";
    }

    @RequestMapping("process/list")
    @ResponseBody
    public Map testcase19(@RequestParam int page, int rows){
        PageHelper.startPage(page,rows,true);
        List<Process> processList = processDao.selectProcess();
        PageInfo pageInfo = new PageInfo(processList);
        long total = pageInfo.getTotal();
        Map map = new HashMap();
        map.put("total",total);
        map.put("rows",processList);
        return map;
    }

    //添加工序信息
    @RequestMapping("process/add_judge")
    public String testcase36(){
        return "process_add";
    }

    @RequestMapping("process/add")
    public String testcase37(){
        return "process_add";
    }

    @RequestMapping("process/insert")
    @ResponseBody
    public Map<String, String> testcase39(Process process){
        Map<String, String> map = new HashMap<>();
        //首先判断输入的工艺要求编号是否重复
        String ProcessId = process.getProcessId();
        List<Process> processList =
                processDao.processIdIsexist(ProcessId);

        if (processList.isEmpty()){
            processDao.addProcess(process);
            map.put("status", "200");
            return map;
        }else {
            map.put("msg", "工序编号已存在，请重新输入");
            return map;
        }
    }

    @RequestMapping("technologyPlan/get/{id}")
    @ResponseBody
    public TechnologyPlan testcase40(@PathVariable("id") String id){
        return technologyPlanDao.findTechnologyPlanById(id);
    }

    //删除工序信息
    @RequestMapping("process/delete_judge")
    public String testcase41(){
        return "technologyPlan_list";
    }

    @RequestMapping("process/delete_batch")
    @ResponseBody
    public Map<String, String> testcase42(String[] ids, HttpServletRequest request){
        for (int i = 0; i < ids.length; i++) {
            String tid = ids[i];
            processDao.removeProcessById(tid);
        }
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        return map;
    }

    //修改工序信息

    @RequestMapping("process/edit_judge")
    public String testcase43(){
        return "process_edit";
    }

    @RequestMapping("process/edit")
    public String testcase44(){
        return "process_edit";
    }

    @RequestMapping("process/update_all")
    @ResponseBody
    public Map<String, String> testcase45(Process process){
        int i = processDao.updateProcess(process);
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        return map;
    }

    @RequestMapping("process/get_data")
    @ResponseBody
    public List<Process> testcase46(){
        List<Process> technologyPlans = processDao.selectProcess();

        return technologyPlans;
    }
}
