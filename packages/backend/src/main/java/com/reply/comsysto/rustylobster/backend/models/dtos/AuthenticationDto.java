package com.reply.comsysto.rustylobster.backend.models.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel(description = "Payload that contains user data used to authenticate a client")
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE)
public final class AuthenticationDto {
  @ApiModelProperty(value = "Hashed password of the user client to authenticate", required = true)
  @NotNull
  @NotBlank
  private String password;

  @ApiModelProperty(value = "Username of the client to authenticate", required = true)
  @NotNull
  @NotBlank
  private String username;
}
