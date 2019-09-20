package com.reply.comsysto.rustylobster.backend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reply.comsysto.rustylobster.backend.exceptions.ApiErrorCode;
import com.reply.comsysto.rustylobster.backend.models.dtos.ApiErrorDto;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public final class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
  @Override
  public void commence(
      final HttpServletRequest request,
      final HttpServletResponse response,
      final AuthenticationException authException)
      throws IOException {
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response
        .getOutputStream()
        .println(
            new ObjectMapper()
                .writeValueAsString(
                    new ApiErrorDto(
                        ApiErrorCode.AUTHENTICATION_ERROR,
                        ApiErrorCode.AUTHENTICATION_ERROR.getValue(),
                        authException.getMessage(),
                        new Date())));
  }
}
