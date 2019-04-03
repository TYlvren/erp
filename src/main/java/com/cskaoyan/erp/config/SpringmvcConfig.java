package com.cskaoyan.erp.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.PostConstruct;


//将该类设置为配置类
@Configuration
//开启MVC注解驱动
@EnableWebMvc
@ComponentScan("com.cskaoyan.erp.controller")
//实现WebMvcConfigurer接口
public class SpringmvcConfig implements WebMvcConfigurer {

    @Bean
    //返回一个视图解析器，来配置一个视图解析器
    public ViewResolver indexViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewNames("index*");
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    //返回一个视图解析器，来配置一个视图解析器
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    //配置并注入文件上传类,需要特定的id
    @Bean("multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(5 * 1024 * 1024);
        return commonsMultipartResolver;
    }
    @Override
    //利用父接口的方法配置资源解析器
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*").addResourceLocations("/");
    }


    /*//配置格式转换器，并注入
    @Autowired
    ConfigurableConversionService configurableConversionService;

    //@PostConstruct在构造函数之后紧接着执行，进行初始化
    @PostConstruct
    public void addMyConversionService(){
        configurableConversionService.addConverter(new StringToDateConverter());
    }

    //@Primary注解的组件将优先被加载，即接口有多个实现时，如果不使用@Qualifier会加载被@Primary注解的组件
    @Primary
    @Bean
    public ConfigurableConversionService configurableConversionService(){
        return configurableConversionService;
    }*/



 /*   @Override
    //接口的方法，添加一个阻截器
    public void addInterceptors(InterceptorRegistry registry) {
        AuthorizedInterceptor myInterceptor = new AuthorizedInterceptor();
        registry.addInterceptor(myInterceptor);
    }*/


  /*  @Override
    //异常处理器
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        System.out.println("出错了");
        resolvers.add(new CustomExceptionResolver());
    }*/
}
