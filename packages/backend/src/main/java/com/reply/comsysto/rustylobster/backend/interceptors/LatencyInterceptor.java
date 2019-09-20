package com.reply.comsysto.rustylobster.backend.interceptors;

import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public final class LatencyInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(
      final HttpServletRequest request, final HttpServletResponse response, final Object handler)
      throws Exception {
    final Random random = new Random();
    Thread.sleep(random.nextInt(5000));
    return true;
  }
}
