package com.reply.comsysto.rustylobster.backend.daos;

import com.reply.comsysto.rustylobster.backend.models.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {}
