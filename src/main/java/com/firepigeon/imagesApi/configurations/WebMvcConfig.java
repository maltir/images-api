package com.firepigeon.imagesApi.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.firepigeon.imagesApi.util.DtoModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final ApplicationContext applicationContext;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public WebMvcConfig(ApplicationContext applicationContext, MongoTemplate mongoTemplate) {
        this.applicationContext = applicationContext;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        WebMvcConfigurer.super.addArgumentResolvers(argumentResolvers);
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().applicationContext(this.applicationContext).build();
        argumentResolvers.add(new DtoModelMapper(objectMapper, mongoTemplate));
    }
}
