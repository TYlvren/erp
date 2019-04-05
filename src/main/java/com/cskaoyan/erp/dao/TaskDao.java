package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskDao {

    List<Task> selectAllTask();

    Task selectTaskById(String id);

    int insertTask(Task task);

    int updateTask(Task task);

    int deleteTaskByIds(String[] ids);

    List<Task> selectTaskBySearch(@Param("condition") String condition,@Param("searchValue") String searchValue);
}