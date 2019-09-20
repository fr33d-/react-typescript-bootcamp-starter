package com.reply.comsysto.rustylobster.backend.models.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.reply.comsysto.rustylobster.backend.exceptions.ApiErrorCode;
import com.reply.comsysto.rustylobster.backend.exceptions.ApiException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Value;

@Value
@ApiModel(description = "This response contains information about any handled exception")
@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE)
public final class ApiErrorDto {
  @ApiModelProperty(
      value = "Machine readable error name of this particular Api error",
      required = true)
  private ApiErrorCode errorCode;

  @ApiModelProperty(
      value = "Machine readable numerical error code of this particular Api error",
      required = true)
  private int errorNumber;

  @ApiModelProperty(
      value = "Human readable error message describing this particular Api error",
      required = true)
  private String message;

  @ApiModelProperty(value = "Timestamp of the occurrence of the error", required = true)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date timestamp;

  public static ApiErrorDto of(final ApiException exception) {
    return new ApiErrorDto(
        exception.getErrorCode(),
        exception.getErrorCode().getValue(),
        exception.getMessage(),
        exception.getTimestamp());
  }
}
