package com.week5assignment.week5assignment.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
  @Bean
  public Docket swaggerConfiguration() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .paths(PathSelectors.ant("/week5Assignment/**"))
        .apis(RequestHandlerSelectors.basePackage("com.week5assignment.week5assignment"))
        .build()
        .apiInfo(apiCustomData());
  }

  private ApiInfo apiCustomData() {
    return new ApiInfo("Week 5 Assignment",
        "Spring Boot Documentation",
        "1.0",
        "Spring Boot Service Terms",
        new Contact("Piggy Inu", "My URL", "piggy Email"),
        "General License",
        "License URL",
        Collections.emptyList());
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
  }

}
