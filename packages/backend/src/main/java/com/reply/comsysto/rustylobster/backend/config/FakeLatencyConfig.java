package com.reply.comsysto.rustylobster.backend.config;

import com.reply.comsysto.rustylobster.backend.interceptors.LatencyInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ConditionalOnExpression("${interceptors.should-fake-latency:true}")
public class FakeLatencyConfig implements WebMvcConfigurer {
  @Override
  public void addInterceptors(final InterceptorRegistry registry) {
    registry.addInterceptor(new LatencyInterceptor());
  }
}
