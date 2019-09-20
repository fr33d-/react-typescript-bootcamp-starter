package com.reply.comsysto.rustylobster.backend.models.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public final class Burger extends BaseEntity {
  @OneToMany(targetEntity = BurgerIngredient.class, cascade = CascadeType.ALL, orphanRemoval = true)
  @OrderColumn
  private List<BurgerIngredient> ingredients;

  private String name;
}
