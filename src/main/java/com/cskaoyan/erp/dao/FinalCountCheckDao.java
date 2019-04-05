package com.cskaoyan.erp.dao;


import com.cskaoyan.erp.model.FinalCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalCountCheckDao {
    List<FinalCountCheck> findFCountCheckDao();
    int insertFCountCheckDao(FinalCountCheck finalCountCheck);
    int updateFCountCheckDao(FinalCountCheck finalCountCheck);
    int deleteFCountCheckDao(String[] ids);
    int updateNoteFCountCheckDao(@Param("id") String fCountCheckId, @Param("note") String note);
    List<FinalCountCheck> searchFCountCheckDao(@Param("class1")String searchname,@Param("value1") String searchValue);
}