package com.reply.comsysto.rustylobster.backend.models.entities;

import com.reply.comsysto.rustylobster.backend.models.dtos.IngredientDto;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public final class Ingredient extends BaseEntity {
  private int calories;
  private IngredientCategory category;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  private IngredientStock ingredientStock;

  private String name;
  private BigDecimal price;

  public static Ingredient of(final IngredientDto ingredientDto) {
    var ingredientEntity = new Ingredient();
    ingredientEntity.setId(ingredientDto.getId());
    return ingredientEntity;
  }
}
