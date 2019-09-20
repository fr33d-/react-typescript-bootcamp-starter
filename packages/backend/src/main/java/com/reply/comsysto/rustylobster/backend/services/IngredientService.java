package com.reply.comsysto.rustylobster.backend.services;

import com.reply.comsysto.rustylobster.backend.daos.IngredientRepository;
import com.reply.comsysto.rustylobster.backend.exceptions.IngredientNotFoundException;
import com.reply.comsysto.rustylobster.backend.models.dtos.IngredientDto;
import com.reply.comsysto.rustylobster.backend.models.dtos.IngredientStockDto;
import com.reply.comsysto.rustylobster.backend.models.entities.IngredientCategory;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class IngredientService {
  private final IngredientRepository ingredientRepository;

  public IngredientDto getIngredientById(final Long id) {
    return IngredientDto.of(
        this.ingredientRepository
            .findById(id)
            .orElseThrow(() -> new IngredientNotFoundException(id)));
  }

  public IngredientStockDto getIngredientStockById(final Long id) {
    return IngredientStockDto.of(
        this.ingredientRepository
            .findById(id)
            .orElseThrow(() -> new IngredientNotFoundException(id))
            .getIngredientStock());
  }

  public List<IngredientDto> getIngredients(final IngredientCategory ingredientCategory) {
    return this.ingredientRepository.findAll().stream()
        .filter(
            ingredient ->
                ingredientCategory == null || ingredient.getCategory() == ingredientCategory)
        .map(IngredientDto::of)
        .collect(Collectors.toList());
  }
}
