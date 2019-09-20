package com.reply.comsysto.rustylobster.backend.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("interceptors")
@Data
public final class InterceptorConfigProperties {
  /**
   * Gets or sets a boolean value indicating whether the server should handle all requests after a
   * small and random amount of time by letting the thread sleep.
   */
  private boolean shouldFakeLatency;
}
