package com.reply.comsysto.rustylobster.backend.exceptions;

import org.springframework.http.HttpStatus;

public final class UserAccountNotFoundException extends ApiException {
  public UserAccountNotFoundException() {
    super(
        ApiErrorCode.USER_ACCOUNT_NOT_FOUND,
        "Could not find user account with the specified name and password",
        HttpStatus.NOT_FOUND);
  }
}
