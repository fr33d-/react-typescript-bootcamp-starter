package com.reply.comsysto.rustylobster.backend.controllers;

import com.reply.comsysto.rustylobster.backend.models.dtos.ApiErrorDto;
import com.reply.comsysto.rustylobster.backend.models.dtos.AuthenticationDto;
import com.reply.comsysto.rustylobster.backend.models.dtos.JwtAuthenticationDto;
import com.reply.comsysto.rustylobster.backend.services.AuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Authentication")
@RestController
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthenticationController {
  private final AuthenticationService authenticationService;

  @ApiOperation("Creates an auth token based on the supplied user data")
  @ApiResponses({@ApiResponse(code = 404, message = "Not Found", response = ApiErrorDto.class)})
  @PostMapping("/token")
  public ResponseEntity<JwtAuthenticationDto> createAuthToken(
      @ApiParam(value = "User data to authenticate a client", required = true) @Valid @RequestBody
          final AuthenticationDto authenticationDto) {
    return ResponseEntity.ok(
        this.authenticationService.createJsonWebToken(
            authenticationDto.getUsername(), authenticationDto.getPassword()));
  }
}
