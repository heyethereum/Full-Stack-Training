package com.week5assignment.week5assignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringConfig implements WebMvcConfigurer {
  @Autowired
  TokenInterceptor tokenInterceptor;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowCredentials(true)
        .allowedOriginPatterns("*")
        .allowedHeaders("*")
        .allowedMethods("*")
        .maxAge(3600);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {

    registry.addInterceptor(tokenInterceptor).addPathPatterns("/**")
        .excludePathPatterns(
            "/v2/**",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/webjars/**");
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/swagger-ui/**")
        .addResourceLocations("classpath:/META-INF/resources/");

    registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
}
