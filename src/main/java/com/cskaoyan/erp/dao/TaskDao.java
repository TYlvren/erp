package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.Task;

import java.util.List;

public interface TaskDao {

    List<Task> selectAllTask();

    Task selectTaskById(String id);

    int insertTask(Task task);

    int updateTask(Task task);

    int deleteTaskByIds(String[] ids);
}