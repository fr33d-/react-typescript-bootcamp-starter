package com.reply.comsysto.rustylobster.backend.exceptions;

import org.springframework.http.HttpStatus;

public final class IngredientNotFoundException extends ApiException {
  public IngredientNotFoundException(final Long id) {
    super(
        ApiErrorCode.INGREDIENT_NOT_FOUND,
        String.format("Could not find ingredient with id %d", id),
        HttpStatus.NOT_FOUND);
  }
}
