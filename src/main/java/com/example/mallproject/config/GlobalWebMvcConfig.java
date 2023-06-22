package com.example.mallproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zzzk1
 */
@Configuration
public class GlobalWebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
              .allowCredentials(true)
               .allowedHeaders("*")
                .allowedMethods("*")
               .maxAge(3600L);
   }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加权限拦截器
        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**","/login");
    }
}
