package com.reply.comsysto.rustylobster.backend.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jwt")
@Data
public final class JwtConfigProperties {
  /** Gets or sets the secret key used for the creation and verification of issued JWTs. */
  private String secret;
}
