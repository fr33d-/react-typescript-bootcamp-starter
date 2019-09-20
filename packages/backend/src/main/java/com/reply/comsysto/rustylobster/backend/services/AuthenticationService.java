package com.reply.comsysto.rustylobster.backend.services;

import com.reply.comsysto.rustylobster.backend.daos.UserAccountRepository;
import com.reply.comsysto.rustylobster.backend.exceptions.UserAccountNotFoundException;
import com.reply.comsysto.rustylobster.backend.models.dtos.JwtAuthenticationDto;
import com.reply.comsysto.rustylobster.backend.models.entities.UserAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public final class AuthenticationService {
  private final JwtService jwtService;
  private final UserAccountRepository userAccountRepository;

  public JwtAuthenticationDto createJsonWebToken(final String username, final String password) {
    return this.userAccountRepository
        .findOne(Example.of(new UserAccount(null, username)))
        .filter(account -> account.getPassword().equals(password))
        .map(
            account ->
                new JwtAuthenticationDto(this.jwtService.generateToken(account.getUsername())))
        .orElseThrow(UserAccountNotFoundException::new);
  }
}
