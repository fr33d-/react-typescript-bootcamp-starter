package com.reply.comsysto.rustylobster.backend.models.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.reply.comsysto.rustylobster.backend.security.JwtAuthentication;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
@ApiModel(description = "Contains the auth token used for secured endpoints")
@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE)
public final class JwtAuthenticationDto {
  @ApiModelProperty(value = "Auth token necessary for secured endpoints", required = true)
  private String token;

  public static JwtAuthenticationDto of(final JwtAuthentication jwtAuthentication) {
    return new JwtAuthenticationDto(jwtAuthentication.getToken());
  }
}
