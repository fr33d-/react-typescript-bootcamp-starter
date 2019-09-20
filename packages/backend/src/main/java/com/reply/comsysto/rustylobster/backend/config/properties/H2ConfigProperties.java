package com.reply.comsysto.rustylobster.backend.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("h2")
@Data
public final class H2ConfigProperties {
  private Tcp tcp;
  private Web web;

  @Data
  private static class Tcp {
    /**
     * Gets or sets a boolean value indicating whether a TCP server to connect to the H2 database
     * should be started on application startup.
     */
    private boolean isEnabled;
  }

  @Data
  private static class Web {
    /**
     * Gets or sets a boolean value indicating whether a web server interface to connect to the H2
     * database should be started on application startup.
     */
    private boolean isEnabled;
  }
}
