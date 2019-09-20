package com.reply.comsysto.rustylobster.backend.models.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel(description = "Payload that contains data for a new burger")
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE)
public final class CreateBurgerDto {
  @ApiModelProperty(
      value = "Ordered list of ingredient IDs in this particular burger",
      required = true)
  @NotNull(message = "The burger must contain ingredients")
  private List<Long> ingredientIds;

  @ApiModelProperty(value = "Non-localized custom name of the burger", required = true)
  @NotNull(message = "The burger must have a name")
  @NotBlank(message = "The burger name cannot be empty")
  private String name;
}
