package com.cskaoyan.erp.service.impl;

import com.cskaoyan.erp.dao.UnQualifyApplyDao;
import com.cskaoyan.erp.model.UnQualifyApply;
import com.cskaoyan.erp.service.ErpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class ErpServiceImpl implements ErpService {

    @Autowired
    private UnQualifyApplyDao  unQualifyApplyDao;
    @Override
    public List<UnQualifyApply> findUnqualifyList() {

        return unQualifyApplyDao.findUnqualifyListDao();
    }
}
