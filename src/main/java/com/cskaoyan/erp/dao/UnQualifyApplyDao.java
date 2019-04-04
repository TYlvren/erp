package com.cskaoyan.erp.dao;

import com.cskaoyan.erp.model.UnQualifyApply;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface UnQualifyApplyDao {
    List<UnQualifyApply> findUnqualifyListDao();
    void addUnqualifyDao(UnQualifyApply unQualifyApply);
}