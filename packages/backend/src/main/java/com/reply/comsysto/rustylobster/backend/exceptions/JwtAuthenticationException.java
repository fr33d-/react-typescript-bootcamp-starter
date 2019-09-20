package com.reply.comsysto.rustylobster.backend.exceptions;

import org.springframework.security.core.AuthenticationException;

public final class JwtAuthenticationException extends AuthenticationException {
  public JwtAuthenticationException(final String message) {
    super(message);
  }
}
