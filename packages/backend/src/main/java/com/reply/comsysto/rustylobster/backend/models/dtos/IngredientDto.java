package com.reply.comsysto.rustylobster.backend.models.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.reply.comsysto.rustylobster.backend.models.entities.Ingredient;
import com.reply.comsysto.rustylobster.backend.models.entities.IngredientCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.Value;

@Value
@ApiModel(description = "Represents an ingredient and its details")
@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE)
public final class IngredientDto {
  @ApiModelProperty(value = "Average amount of calories of the ingredient", required = true)
  private int calories;

  @ApiModelProperty(value = "Category of the ingredient", required = true)
  private IngredientCategory category;

  @ApiModelProperty(value = "Database generated ingredient ID", required = true)
  private Long id;

  @ApiModelProperty(value = "Non-localized English name of the ingredient", required = true)
  private String name;

  @ApiModelProperty(value = "Price of the ingredient per unit in Fantasy Dollars", required = true)
  private BigDecimal price;

  public static IngredientDto of(final Ingredient ingredient) {
    return new IngredientDto(
        ingredient.getCalories(),
        ingredient.getCategory(),
        ingredient.getId(),
        ingredient.getName(),
        ingredient.getPrice());
  }
}
