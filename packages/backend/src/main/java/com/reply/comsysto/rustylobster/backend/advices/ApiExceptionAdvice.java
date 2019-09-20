package com.reply.comsysto.rustylobster.backend.advices;

import com.reply.comsysto.rustylobster.backend.exceptions.ApiException;
import com.reply.comsysto.rustylobster.backend.exceptions.ForbiddenException;
import com.reply.comsysto.rustylobster.backend.models.dtos.ApiErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public final class ApiExceptionAdvice {
  @ResponseBody
  @ExceptionHandler(ApiException.class)
  public ResponseEntity<ApiErrorDto> handleError(final ApiException exception) {
    return ResponseEntity.status(exception.getStatusCode()).body(ApiErrorDto.of(exception));
  }

  @ResponseBody
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<ApiErrorDto> handleHttpRequestMethodNotSupportedException(
      final HttpRequestMethodNotSupportedException exception) {
    var forbiddenException = new ForbiddenException();
    return ResponseEntity.status(forbiddenException.getStatusCode())
        .body(ApiErrorDto.of(forbiddenException));
  }
}
