package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Process;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessDao {
    List<Process> selectProcess();

    Process selectProcessById(@Param("id") String id);
}