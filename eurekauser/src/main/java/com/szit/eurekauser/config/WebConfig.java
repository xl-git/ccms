package com.szit.eurekauser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/"+"images/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/"+"js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/"+"css/");
    }
}
