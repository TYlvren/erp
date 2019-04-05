package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Process;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessDao {
    List<Process> selectProcess();

    Process selectProcessById(@Param("id") String id);

    List<Process> processIdIsexist(@Param("processid") String processId);

    void addProcess(@Param("process") Process pro);

    void removeProcessById(@Param("id") String tid);

    int updateProcess(@Param("process") Process process);
}