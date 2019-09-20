package com.reply.comsysto.rustylobster.backend.security;

import com.google.common.collect.ImmutableList;
import com.reply.comsysto.rustylobster.backend.config.MethodSecurityConfig;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class JwtAuthenticatedProfile implements Authentication {
  private String username;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return ImmutableList.of(new SimpleGrantedAuthority(MethodSecurityConfig.ROLE_USER));
  }

  @Override
  public Object getCredentials() {
    return null;
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
    return this.username;
  }

  @Override
  public boolean isAuthenticated() {
    return true;
  }

  @Override
  public void setAuthenticated(final boolean isAuthenticated) throws IllegalArgumentException {}
}
