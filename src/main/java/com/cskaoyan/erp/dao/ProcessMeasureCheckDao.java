package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.ProcessMeasureCheck;

import java.util.List;

public interface ProcessMeasureCheckDao {
    List<ProcessMeasureCheck> findPMeasureCheckDao();
    int insertPMeasureCheckDao(ProcessMeasureCheck processMeasureCheck);

}