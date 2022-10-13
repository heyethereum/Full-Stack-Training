package com.week5assignment.week5assignment.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.week5assignment.week5assignment.Response.GeneralResponse;
import com.week5assignment.week5assignment.exception.CustomException;
import com.week5assignment.week5assignment.services.UserServiceImpl;

@Configuration
public class TokenInterceptor implements HandlerInterceptor {
  @Autowired
  UserServiceImpl userServiceImpl;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String url = request.getRequestURL().toString();
    if (url.endsWith("userModelLogin"))
      return true;
    System.out.println("hello!" + url);
    String token = request.getHeader("token");
    String userId = request.getHeader("userId");
    try {
      Long id = Long.parseLong(userId);
      return (userServiceImpl.validateToken(token, id));
    } catch (Exception e) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid userId");
    }
    return false;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      @Nullable ModelAndView modelAndView) throws Exception {
    // TODO Auto-generated method stub
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
      @Nullable Exception ex) throws Exception {
    // TODO Auto-generated method stub
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }

}
