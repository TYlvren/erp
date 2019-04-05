package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.FinalMeasureCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalMeasureCheckDao {

    List<FinalMeasureCheck> findFMeasureCheckDao();
    int insertFMeasureCheckDao(FinalMeasureCheck finalMeasureCheck);
    int updateFMeasureCheckDao(FinalMeasureCheck processCountCheck);
    int deleteFMeasureCheckDao(String[] ids);
    int updateNoteFMeasureCheckDao(@Param("id") String pCountCheckId, @Param("note") String note);
}