package com.reply.comsysto.rustylobster.backend.config;

import com.reply.comsysto.rustylobster.backend.security.JwtAuthenticationEntryPoint;
import com.reply.comsysto.rustylobster.backend.security.JwtAuthenticationFilter;
import com.reply.comsysto.rustylobster.backend.security.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  private final JwtAuthenticationProvider jwtAuthenticationProvider;
  private final JwtAuthenticationEntryPoint unauthorizedHandler;

  @Bean
  public JwtAuthenticationFilter authenticationTokenFilterBean() {
    return new JwtAuthenticationFilter();
  }

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http.csrf()
        .disable()
        .exceptionHandling()
        .authenticationEntryPoint(this.unauthorizedHandler)
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .anyRequest()
        .permitAll()
        .and()
        .addFilterBefore(
            this.authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class)
        .headers()
        .cacheControl();
  }

  @Autowired
  public void configureAuthentication(
      final AuthenticationManagerBuilder authenticationManagerBuilder) {
    authenticationManagerBuilder.authenticationProvider(this.jwtAuthenticationProvider);
  }
}
