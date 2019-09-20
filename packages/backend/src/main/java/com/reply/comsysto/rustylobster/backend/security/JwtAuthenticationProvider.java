package com.reply.comsysto.rustylobster.backend.security;

import com.reply.comsysto.rustylobster.backend.exceptions.JwtAuthenticationException;
import com.reply.comsysto.rustylobster.backend.services.JwtService;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public final class JwtAuthenticationProvider implements AuthenticationProvider {
  private final JwtService jwtService;

  @Override
  public Authentication authenticate(final Authentication authentication) {
    try {
      final String token = (String) authentication.getCredentials();
      final String username = this.jwtService.getUsernameFromToken(token);
      return this.jwtService
          .isTokenValid(token)
          .map(result -> new JwtAuthenticatedProfile(username))
          .orElseThrow(() -> new JwtAuthenticationException("JWT token validation failed"));
    } catch (JwtException exception) {
      log.error(String.format("Invalid JWT Token: %s", exception.getMessage()));
      throw new JwtAuthenticationException("JWT token verification failed");
    }
  }

  @Override
  public boolean supports(final Class<?> authentication) {
    return JwtAuthentication.class.equals(authentication);
  }
}
