package com.reply.comsysto.rustylobster.backend.exceptions;

import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.springframework.http.HttpStatus;

@Value
@NonFinal
@EqualsAndHashCode(callSuper = true)
public abstract class ApiException extends RuntimeException {
  private ApiErrorCode errorCode;
  private String message;
  private HttpStatus statusCode;
  private Date timestamp;

  ApiException(final ApiErrorCode errorCode, final String message, final HttpStatus httpStatus) {
    super(message);
    this.errorCode = errorCode;
    this.message = message;
    this.statusCode = httpStatus;
    this.timestamp = new Date();
  }
}
