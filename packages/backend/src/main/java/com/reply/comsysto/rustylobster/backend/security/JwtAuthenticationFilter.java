package com.reply.comsysto.rustylobster.backend.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public final class JwtAuthenticationFilter extends OncePerRequestFilter {
  @Override
  protected void doFilterInternal(
      final HttpServletRequest request,
      final HttpServletResponse response,
      final FilterChain filterChain)
      throws ServletException, IOException {
    final String requestHeader = request.getHeader("Authorization");

    if (requestHeader != null && requestHeader.startsWith("Bearer")) {
      final String token = requestHeader.substring(7);
      final JwtAuthentication jwtAuthentication = new JwtAuthentication(token);
      SecurityContextHolder.getContext().setAuthentication(jwtAuthentication);
    }
    filterChain.doFilter(request, response);
  }
}
