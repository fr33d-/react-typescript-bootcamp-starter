package com.reply.comsysto.rustylobster.backend.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ApiErrorCodeTests {
  @Test
  void testCodes() {
    assertEquals(1000, ApiErrorCode.BURGER_NOT_FOUND.getValue());
    assertEquals(2000, ApiErrorCode.INGREDIENT_NOT_FOUND.getValue());
    assertEquals(2001, ApiErrorCode.INVALID_INGREDIENT_ID.getValue());
    assertEquals(3000, ApiErrorCode.USER_ACCOUNT_NOT_FOUND.getValue());
    assertEquals(4000, ApiErrorCode.AUTHENTICATION_ERROR.getValue());
    assertEquals(5000, ApiErrorCode.FORBIDDEN.getValue());
  }
}
