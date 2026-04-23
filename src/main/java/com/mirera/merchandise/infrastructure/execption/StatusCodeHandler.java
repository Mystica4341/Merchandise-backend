package com.mirera.merchandise.infrastructure.execption;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class StatusCodeHandler {

  @Bean
  public AuthenticationEntryPoint authEntryPoint() {
      return (request, response, authException) -> {
          response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
          response.setContentType("application/json");
          response.setCharacterEncoding("UTF-8");
          response.getWriter().write("""
              {
                "status": 401,
                "message": "Bạn cần đăng nhập để truy cập",
                "path": "%s"
              }
              """.formatted(request.getRequestURI()));
      };
  }

  @Bean
  public AccessDeniedHandler accessDeniedHandler() {
      return (request, response, accessDeniedException) -> {
          response.setStatus(HttpServletResponse.SC_FORBIDDEN);
          response.setContentType("application/json");
          response.setCharacterEncoding("UTF-8");
          response.getWriter().write("""
              {
                "status": 403,
                "message": "Bạn không có quyền truy cập tài nguyên này",
                "path": "%s"
              }
              """.formatted(request.getRequestURI()));
      };
  }
}