/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuranov.phonebook.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.resource.ResourceUrlProvider;
import org.springframework.web.util.UrlPathHelper;

/**
 *
 * @author mihail
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

  @Bean
  @Override
  public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
    RequestMappingHandlerAdapter handlerAdapter = super.requestMappingHandlerAdapter();
    return handlerAdapter;
  }

    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return super.requestMappingHandlerMapping(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ViewResolver mvcViewResolver() {
        return super.mvcViewResolver(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HttpRequestHandlerAdapter httpRequestHandlerAdapter() {
        return super.httpRequestHandlerAdapter(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected MessageCodesResolver getMessageCodesResolver() {
        return super.getMessageCodesResolver(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UrlPathHelper mvcUrlPathHelper() {
        return super.mvcUrlPathHelper(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResourceUrlProvider mvcResourceUrlProvider() {
        return super.mvcResourceUrlProvider(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HandlerMapping viewControllerHandlerMapping() {
        return super.viewControllerHandlerMapping(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
   registry.addResourceHandler("/**").addResourceLocations(
                "/");    }
  
  
}

