package com.reply.comsysto.rustylobster.backend.daos;

import com.reply.comsysto.rustylobster.backend.models.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {}
