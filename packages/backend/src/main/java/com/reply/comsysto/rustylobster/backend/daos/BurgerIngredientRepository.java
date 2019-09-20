package com.reply.comsysto.rustylobster.backend.daos;

import com.reply.comsysto.rustylobster.backend.models.entities.BurgerIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurgerIngredientRepository extends JpaRepository<BurgerIngredient, Long> {}
