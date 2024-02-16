package com.example.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/User/profile",
                "/navigation/home",
                "/navigation/contact",
                "/navigation/specialists",
                "/navigation/faq",
                "/navigation/testimony",
                "/navigation/lightHarassment",
                "/navigation/severeHarassment",
                "/navigation/User/loadProfile",
                "/navigation/loadResponseFormChild",
                "/navigation/loadResponseForm");
    }
}
