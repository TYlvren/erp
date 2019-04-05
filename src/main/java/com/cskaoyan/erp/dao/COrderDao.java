package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.COrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface COrderDao {

    /**
     * 查询所有的客户订单
     * @return
     */
    List<COrder> selectALLCOder();


    COrder selectCOrderById(String id);

    int insertOrder(COrder cOrder);

    int updateOrder(COrder cOrder);

    int deleteOrderByIds(String[] ids);

    List<COrder> selectCOderBySearch(@Param("condition") String condition, @Param("searchValue") String searchValue);
}