package com.cskaoyan.erp.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;


//继承AACDSI 配置启动类,进行web.xml中的配置
public class WebAppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    //配置SpringConfig，应用启动时加载
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    //配置SpringMVCConfig，访问Servlet时加载
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringmvcConfig.class};
    }

    @Override
    //配置Servlet的映射路径
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    //配置过滤器,返回过滤器数组
    protected Filter[] getServletFilters() {
        //配置编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("utf-8");
        return new Filter[]{characterEncodingFilter};
    }

}
