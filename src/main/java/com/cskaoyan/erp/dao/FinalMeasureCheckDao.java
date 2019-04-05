package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.FinalMeasureCheck;

import java.util.List;

public interface FinalMeasureCheckDao {

    List<FinalMeasureCheck> findFMeasureCheckDao();
//    int insertPCountCheckDao(ProcessCountCheck processCountCheck);
//    int updatePCountCheckDao(ProcessCountCheck processCountCheck);
//    int deletePCountCheckDao(String[] ids);
//    int updateNotePCountCheckDao(@Param("id") String pCountCheckId, @Param("note") String note);
}