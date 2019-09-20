package com.reply.comsysto.rustylobster.backend.exceptions;

import org.springframework.http.HttpStatus;

public final class ForbiddenException extends ApiException {
  public ForbiddenException() {
    super(ApiErrorCode.FORBIDDEN, "Forbidden", HttpStatus.FORBIDDEN);
  }
}
