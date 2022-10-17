package com.week5assignment.week5assignment.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.week5assignment.week5assignment.exception.CustomException;
import com.week5assignment.week5assignment.services.UserServiceImpl;

@Configuration
public class TokenInterceptor implements HandlerInterceptor {
  @Autowired
  UserServiceImpl userServiceImpl;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    try {
      String url = request.getRequestURL().toString();

      System.out.println("URL: " + url + ", method: " + request.getMethod());
      if (request.getMethod().equals("OPTIONS")) {
        return true;
      }
      if (url.endsWith("userModelLogin") || url.contains("Register"))
        return true;
      if (url.contains("readImage"))
        return true;
      String token = request.getHeader("token");

      if (token == null || token.isEmpty())
        throw new CustomException("please send the token");

      Long id = userServiceImpl.getIdByToken(token);

      return (userServiceImpl.validateToken(token, id));
    } catch (NumberFormatException e) {
      throw new CustomException("Wrong user Id format");
    } catch (Exception e) {
      throw new CustomException(e.getMessage());
    }
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
