package com.zhenzhen.demo.springboot2.springboot2demo.config;

import com.zhenzhen.demo.springboot2.springboot2demo.filter.LoginFilter;
import com.zhenzhen.demo.springboot2.springboot2demo.interceptor.TestInterceptor;
import com.zhenzhen.demo.springboot2.springboot2demo.servlet.LoginServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.FilterRegistration;

@Configuration
@EnableWebMvc
public class DemoWebConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private TestInterceptor testInterceptor;

    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(testInterceptor)
                        .addPathPatterns("/*");
    }

    @Bean
    public FilterRegistrationBean webFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setFilter(new LoginFilter());
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }


    @Bean
    public ServletRegistrationBean loginServlet(){
        ServletRegistrationBean servletRegistrationBean =
                new ServletRegistrationBean(new LoginServlet(),"/testServlet");
        return servletRegistrationBean;

    }

}
