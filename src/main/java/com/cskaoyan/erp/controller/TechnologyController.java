package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.dao.ProcessDao;
import com.cskaoyan.erp.dao.TechnologyDao;
import com.cskaoyan.erp.dao.TechnologyRequirementDao;
import com.cskaoyan.erp.model.Custom;
import com.cskaoyan.erp.model.Process;
import com.cskaoyan.erp.model.Technology;
import com.cskaoyan.erp.model.TechnologyRequirement;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void testcase02(HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        String rows1 = request.getParameter("rows");
        System.out.println("rows:"+rows1);
        String page1 = request.getParameter("page");
        System.out.println("page:"+page1);
        int rows = Integer.parseInt(rows1);
        int page = Integer.parseInt(page1);
        PageHelper.startPage(page, rows);
        List<Technology> technologyList = technologyDao.selectTechnology();
        int total = technologyDao.selectCountOfTechnology();
        HashMap<String,Object > hashMap = new HashMap();
        hashMap.put("total",total);
        hashMap.put("rows",technologyList);
        JSONObject jsonObject = JSONObject.fromObject(hashMap);
        try {
            response.getWriter().println(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public Map<String,String> testcase05(Technology technology, HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        System.out.println(technology);
        //检查工艺名或工艺号是否已存在
        List<Technology> technologyList = technologyDao.selectTechnologyNameAndIDisExist(
                technology.getTechnologyId(),technology.getTechnologyName());
        System.out.println("technologyList:"+technologyList);
        Map<String,String> map = new HashMap<>();
        if (technologyList.isEmpty()){
            System.out.println("可以添加");
            System.out.println(technology);
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
        return "redirect:list";
    }

    @RequestMapping("technology/delete_batch")
    public String testcase07(HttpServletRequest request){
        String ids = request.getParameter("ids");
        String[] str = ids.split(",");
        for (int i = 0; i < str.length; i++) {
            String tid = str[i];
            technologyDao.removeTechnologyById(tid);
        }
        return "redirect:list";
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
    public String testcase10(Technology technology){
        System.out.println("修改后的technology:"+technology);
        //获取修改后的技术信息，对其进行修改
        technologyDao.updateTechnology(technology);
        return "redirect:find";
    }

    //工艺的信息显示操作custom/get/{id}
    @RequestMapping("technology/get/{id}")
    @ResponseBody
    public Technology getCustom(@PathVariable("id") String id){
        System.out.println(id);
        Technology technologyById = technologyDao.findTechnologyById(id);
        System.out.println("technologyById:"+technologyById);
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
    public HashMap testcase12(HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        String rows1 = request.getParameter("rows");
        System.out.println("rows:"+rows1);
        String page1 = request.getParameter("page");
        System.out.println("page:"+page1);
        int rows = Integer.parseInt(rows1);
        int page = Integer.parseInt(page1);
        PageHelper.startPage(page, rows);
        int total = requirementDao.selectCountOfTechnologyRequirement();
        System.out.println("总数为:"+total);
        List<TechnologyRequirement> technologyRequirements = requirementDao.selectTechnologyRequirement();
        System.out.println("technologyRequirements:"+technologyRequirements);
        for (TechnologyRequirement t :technologyRequirements
             ) {
            t.setTechnologyName(t.getTechnology().getTechnologyName());
            t.setTechnologyId(t.getTechnology().getTechnologyId());
        }
        HashMap<String,Object > hashMap = new HashMap();
        hashMap.put("total",total);
        hashMap.put("rows",technologyRequirements);
        return hashMap;
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
        System.out.println("get_data");
        List<Technology> technologies = technologyDao.selectTechnology();
        return technologies;
    }

    @RequestMapping("technologyRequirement/insert")
    public String testcase17(TechnologyRequirement technologyRequirement){
        System.out.println("新添加信息");
        System.out.println("technologyRequirement:"+technologyRequirement);
        return "technologyRequirement_list";
    }


    /******************工序模块*******************/

    @Autowired
    ProcessDao processDao;

    //process/find
    @RequestMapping("process/find")
    public String testcase18(HttpServletResponse response){
        return "process_list";
    }

    @RequestMapping("process/list")
    @ResponseBody
    public List<Process> testcase19(HttpServletResponse response){
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        List<Process> list = processDao.selectProcess();
        return list;
    }


}
