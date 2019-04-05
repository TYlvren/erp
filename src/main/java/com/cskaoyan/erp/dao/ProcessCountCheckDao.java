package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.ProcessCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessCountCheckDao {
    List<ProcessCountCheck> findPCountCheckDao();
   int insertPCountCheckDao(ProcessCountCheck processCountCheck);
    int updatePCountCheckDao(ProcessCountCheck processCountCheck);
    int deletePCountCheckDao(String[] ids);
    int updateNotePCountCheckDao(@Param("id") String pCountCheckId, @Param("note") String note);
    List<ProcessCountCheck> searchPCountCheckDao(@Param("class1")String searchname,@Param("value1") String searchValue);
}