package com.qin_kai.servlet.test02;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * @author qinkai
 * @date 2021/3/11
 */
@Configuration
public class WebConfig {

    @Bean
    public ServletRegistrationBean<HelloServlet> helloServlet() {
        ServletRegistrationBean<HelloServlet> registrationBean = new ServletRegistrationBean<>();
        registrationBean.setServlet(new HelloServlet());
        registrationBean.setName("helloServlet");
        registrationBean.setUrlMappings(Collections.singletonList("/hello"));
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<HelloFilter> helloFilter() {
        FilterRegistrationBean<HelloFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setName("helloFilter");
        registrationBean.setFilter(new HelloFilter());
        registrationBean.setUrlPatterns(Collections.singletonList("/hello"));
        return registrationBean;
    }

}
