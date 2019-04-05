package com.cskaoyan.erp.aop;

import com.cskaoyan.erp.model.COrder;
import com.cskaoyan.erp.util.PageModel;
import com.github.pagehelper.PageHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("pageModelAspect")
public class PageModelAspect<T> {

    public Object findListAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        int page = (int) args[0];
        int row = (int)args[1];
        PageHelper.startPage(page, row, true);
        Object proceed = joinPoint.proceed();
        List<T> list = (List<T>)proceed;
        return new PageModel<>(list);
    }

}
