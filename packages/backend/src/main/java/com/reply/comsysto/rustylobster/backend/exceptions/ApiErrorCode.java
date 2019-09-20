package com.reply.comsysto.rustylobster.backend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApiErrorCode {
  BURGER_NOT_FOUND(1000),
  INGREDIENT_NOT_FOUND(2000),
  INVALID_INGREDIENT_ID(2001),
  USER_ACCOUNT_NOT_FOUND(3000),
  AUTHENTICATION_ERROR(4000),
  FORBIDDEN(5000);
  private int value;
}
