package com.reply.comsysto.rustylobster.backend.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public final class JwtService {
  @Value("${jwt.secret}")
  private String secret;

  private Date calculateExpirationDate(final Date createdAt) {
    return new Date(createdAt.getTime() + 15 * 60 * 1000);
  }

  String generateToken(final String username) {
    final Date createdAt = new Date();
    final Date expirationDate = this.calculateExpirationDate(createdAt);
    return Jwts.builder()
        .setClaims(new HashMap<>())
        .setSubject(username)
        .setIssuedAt(createdAt)
        .setExpiration(expirationDate)
        .signWith(Keys.hmacShaKeyFor(this.secret.getBytes()))
        .compact();
  }

  private Claims getAllClaimsFromToken(final String token) {
    return Jwts.parser()
        .setSigningKey(Keys.hmacShaKeyFor(this.secret.getBytes()))
        .parseClaimsJws(token)
        .getBody();
  }

  public String getUsernameFromToken(final String token) {
    return this.getAllClaimsFromToken(token).getSubject();
  }

  public Optional<Boolean> isTokenValid(final String token) {
    final Date expirationDate = this.getAllClaimsFromToken(token).getExpiration();
    return expirationDate.after(new Date()) ? Optional.of(Boolean.TRUE) : Optional.empty();
  }
}
