package com.reply.comsysto.rustylobster.backend.services;

import com.reply.comsysto.rustylobster.backend.daos.BurgerRepository;
import com.reply.comsysto.rustylobster.backend.exceptions.BurgerNotFoundException;
import com.reply.comsysto.rustylobster.backend.models.dtos.BurgerDto;
import com.reply.comsysto.rustylobster.backend.models.dtos.CreateBurgerDto;
import com.reply.comsysto.rustylobster.backend.models.dtos.IngredientDto;
import com.reply.comsysto.rustylobster.backend.models.entities.Burger;
import com.reply.comsysto.rustylobster.backend.models.entities.BurgerIngredient;
import com.reply.comsysto.rustylobster.backend.models.entities.Ingredient;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class BurgerService {
  private final BurgerRepository burgerRepository;
  private final IngredientService ingredientService;

  public BurgerDto createBurger(final CreateBurgerDto createBurgerDto) {
    final Burger burger =
        new Burger(
            createBurgerDto.getIngredientIds().stream()
                .map(this.ingredientService::getIngredientById)
                .map(ingredientDto -> new BurgerIngredient(Ingredient.of(ingredientDto)))
                .collect(Collectors.toList()),
            createBurgerDto.getName());
    return BurgerDto.of(this.burgerRepository.save(burger));
  }

  public void deleteBurgerById(final Long id) {
    try {
      this.burgerRepository.deleteById(id);
    } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
      throw new BurgerNotFoundException(id);
    }
  }

  public BurgerDto getBurgerById(final Long id) {
    return this.burgerRepository
        .findById(id)
        .map(BurgerDto::of)
        .orElseThrow(() -> new BurgerNotFoundException(id));
  }

  public List<BurgerDto> getBurgers() {
    return this.burgerRepository.findAll().stream().map(BurgerDto::of).collect(Collectors.toList());
  }

  public List<IngredientDto> getIngredientsByBurgerId(final Long id) {
    return this.burgerRepository.findById(id).orElseThrow(() -> new BurgerNotFoundException(id))
        .getIngredients().stream()
        .map(BurgerIngredient::getIngredient)
        .map(IngredientDto::of)
        .collect(Collectors.toList());
  }
}
