package com.cskaoyan.erp.dao;

import com.cskaoyan.erp.model.UnQualifyApply;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface UnQualifyApplyDao {
    List<UnQualifyApply> findUnqualifyListDao();
    int addUnqualifyDao(UnQualifyApply unQualifyApply);
    int updateUnqualifyDao(UnQualifyApply unQualifyApply);
    int deleteUnqualifyDao(String[] ids);
    int updateNoteByUnqualifyApplyIdDao(@Param("id") String unqualifyApplyId,@Param("note") String note);
    List<UnQualifyApply> searchUnqualifyDao(@Param("class1")String searchname,@Param("value1") String searchValue);

}