package com.reply.comsysto.rustylobster.backend.security;

import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class JwtAuthentication implements Authentication {
  private String token;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public Object getCredentials() {
    return this.token;
  }

  @Override
  public Object getDetails() {
    return null;
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return null;
  }

  @Override
  public boolean isAuthenticated() {
    return false;
  }

  @Override
  public void setAuthenticated(final boolean isAuthenticated) throws IllegalArgumentException {}
}
