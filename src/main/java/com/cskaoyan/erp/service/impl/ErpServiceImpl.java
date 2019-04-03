package com.cskaoyan.erp.service.impl;

<<<<<<< HEAD
import com.cskaoyan.erp.dao.UnQualifyApplyDao;
import com.cskaoyan.erp.model.UnQualifyApply;
import com.cskaoyan.erp.service.ErpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class ErpServiceImpl implements ErpService {

    @Autowired
    private UnQualifyApplyDao  unQualifyApplyDao;
    @Override
    public List<UnQualifyApply> findUnqualifyList() {

        return unQualifyApplyDao.findUnqualifyListDao();
    }
=======
import com.cskaoyan.erp.dao.COrderDao;
import com.cskaoyan.erp.model.COrder;
import com.cskaoyan.erp.service.ErpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service("erpService")
public class ErpServiceImpl implements ErpService {


    /*****************计划进度接口实现*************************************/
    @Autowired
    private COrderDao cOrderDao;
    /**
     * 查询订单API的实现
     * @see { ErpService }
     * @return
     */
    @Override
    public List<COrder> findCOrder() {
        return cOrderDao.selectALLCOder();
    }


    /*****************设备管理接口实现*************************************/


    /*****************工艺监控接口实现*************************************/


    /*****************物料监控接口实现*************************************/


    /*****************质量监控接口实现*************************************/


    /*****************人员监控接口实现*************************************/




    /*****************系统管理接口实现*************************************/

>>>>>>> 535d6a64a4e5652c2f14b2fd2481f72daddf8c66
}
