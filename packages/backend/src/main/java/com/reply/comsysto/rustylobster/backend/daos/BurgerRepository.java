package com.reply.comsysto.rustylobster.backend.daos;

import com.reply.comsysto.rustylobster.backend.models.entities.Burger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurgerRepository extends JpaRepository<Burger, Long> {}
