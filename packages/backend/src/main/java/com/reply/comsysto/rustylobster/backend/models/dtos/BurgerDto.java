package com.reply.comsysto.rustylobster.backend.models.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.reply.comsysto.rustylobster.backend.models.entities.Burger;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Value;

@Value
@ApiModel(description = "Contains the details of a particular burger")
@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE)
public final class BurgerDto {
  @ApiModelProperty(value = "Database generated burger ID", required = true)
  private Long id;

  @ApiModelProperty(
      value = "Ordered list of ingredient IDs in this particular burger",
      required = true)
  private List<Long> ingredientIds;

  @ApiModelProperty(value = "Non-localized custom name of the burger", required = true)
  private String name;

  public static BurgerDto of(final Burger burger) {
    return new BurgerDto(
        burger.getId(),
        burger.getIngredients().stream()
            .map(burgerIngredient -> burgerIngredient.getIngredient().getId())
            .collect(Collectors.toList()),
        burger.getName());
  }
}
