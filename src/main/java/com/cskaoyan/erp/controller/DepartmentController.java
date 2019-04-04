package com.cskaoyan.erp.controller;

import com.cskaoyan.erp.service.ErpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author zi_an
 * Date 2019/4/3 time 23:07
 */
@Controller
public class DepartmentController {
 @Autowired
 private ErpService erpService;
@RequestMapping("department/departmentList")
 public String selectDepartment(){
 return "departmentList";
}


}
