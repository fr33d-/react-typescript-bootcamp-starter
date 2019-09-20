package com.reply.comsysto.rustylobster.backend.exceptions;

import org.springframework.http.HttpStatus;

public final class BurgerNotFoundException extends ApiException {
  public BurgerNotFoundException(final Long id) {
    super(
        ApiErrorCode.BURGER_NOT_FOUND,
        String.format("Could not find burger with id %d", id),
        HttpStatus.NOT_FOUND);
  }
}
