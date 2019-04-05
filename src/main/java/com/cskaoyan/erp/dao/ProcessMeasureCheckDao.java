package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.ProcessMeasureCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMeasureCheckDao {
    List<ProcessMeasureCheck> findPMeasureCheckDao();
    int insertPMeasureCheckDao(ProcessMeasureCheck processMeasureCheck);
    int updatePMeasureCheckDao(ProcessMeasureCheck processMeasureCheck);
    int deletePMeasureCheckDao(String[] ids);
    int updateNotePMeasureCheckDao(@Param("id") String unqualifyApplyId, @Param("note") String note);
    List<ProcessMeasureCheck> searchPMeasureCheckDao(@Param("class1")String searchname,@Param("value1") String searchValue);
}