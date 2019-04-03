package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.COrder;

import java.util.List;

public interface COrderDao {

    /**
     * 查询所有的客户订单
     * @return
     */
    List<COrder> selectALLCOder();


}