package com.reply.comsysto.rustylobster.backend.models.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.reply.comsysto.rustylobster.backend.models.entities.IngredientStock;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
@ApiModel(description = "Contains information about the quantity of a particular ingredient")
@JsonAutoDetect(
    fieldVisibility = Visibility.ANY,
    getterVisibility = Visibility.NONE,
    isGetterVisibility = Visibility.NONE,
    setterVisibility = Visibility.NONE,
    creatorVisibility = Visibility.NONE)
public final class IngredientStockDto {
  @ApiModelProperty(value = "Quantity currently in stock", required = true)
  private int quantity;

  public static IngredientStockDto of(final IngredientStock ingredientStock) {
    return new IngredientStockDto(ingredientStock.getQuantity());
  }
}
