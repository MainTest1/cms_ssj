package com.ssj.cms.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户权限验证的拦截器
 *
 * @author wx
 */
@Component
public class MyUserAuthenticationInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//    Object obj = request.getSession().getAttribute("loginUser");
//    if (null == obj || !(obj instanceof SysUser)) {
//      response.sendRedirect(request.getContextPath() + "/admin/login");
//      return false;
//    }
    return true;
  }


  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

  }
}
