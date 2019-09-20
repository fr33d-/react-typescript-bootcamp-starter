package com.reply.comsysto.rustylobster.backend.controllers;

import com.reply.comsysto.rustylobster.backend.config.SwaggerConfig;
import com.reply.comsysto.rustylobster.backend.models.dtos.ApiErrorDto;
import com.reply.comsysto.rustylobster.backend.models.dtos.BurgerDto;
import com.reply.comsysto.rustylobster.backend.models.dtos.CreateBurgerDto;
import com.reply.comsysto.rustylobster.backend.models.dtos.IngredientDto;
import com.reply.comsysto.rustylobster.backend.security.MustBeAuthenticated;
import com.reply.comsysto.rustylobster.backend.services.BurgerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.ResponseHeader;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@Api(tags = "Burgers")
@RestController
@RequestMapping(value = "/api/burgers", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class BurgerController {
  private final BurgerService burgerService;

  @ApiOperation(
      value = "Create a new custom burger with the specified configuration and name",
      authorizations = {@Authorization(SwaggerConfig.JWT_AUTH_TOKEN)})
  @ApiResponses({
    @ApiResponse(
        code = 201,
        message = "Created",
        responseHeaders = {
          @ResponseHeader(
              name = "location",
              description = "URI pointing to the new burger",
              response = String.class)
        },
        response = Object.class),
    @ApiResponse(code = 401, message = "Unauthorized", response = ApiErrorDto.class),
    @ApiResponse(code = 422, message = "Unprocessable Entity", response = ApiErrorDto.class)
  })
  @MustBeAuthenticated
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public ResponseEntity<?> createBurger(
      @ApiParam(value = "Burger to be added to the database", required = true) @RequestBody @Valid
          final CreateBurgerDto createBurgerDto) {
    final BurgerDto burger = this.burgerService.createBurger(createBurgerDto);
    final URI burgerUri =
        MvcUriComponentsBuilder.fromMethodCall(
                MvcUriComponentsBuilder.on(BurgerController.class).getBurgerById(burger.getId()))
            .build()
            .toUri();
    return ResponseEntity.created(burgerUri).build();
  }

  @ApiOperation(
      value = "Deletes a particular burger using its ID",
      authorizations = {@Authorization(SwaggerConfig.JWT_AUTH_TOKEN)})
  @ApiResponses({
    @ApiResponse(code = 204, message = "No Content", response = Object.class),
    @ApiResponse(code = 401, message = "Unauthorized", response = ApiErrorDto.class),
    @ApiResponse(code = 404, message = "Not Found", response = ApiErrorDto.class)
  })
  @MustBeAuthenticated
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteBurgerById(
      @ApiParam(value = "ID of the burger to delete", required = true, example = "1") @PathVariable
          final Long id) {
    this.burgerService.deleteBurgerById(id);
    return ResponseEntity.noContent().build();
  }

  @ApiOperation("Gets a particular burger using its ID")
  @ApiResponses({@ApiResponse(code = 404, message = "Not Found", response = ApiErrorDto.class)})
  @GetMapping("/{id}")
  public ResponseEntity<BurgerDto> getBurgerById(
      @ApiParam(value = "ID of the burger to query", required = true, example = "1") @PathVariable
          final Long id) {
    return ResponseEntity.ok(this.burgerService.getBurgerById(id));
  }

  @ApiOperation("Returns an unsorted list of all saved burgers")
  @GetMapping
  public ResponseEntity<List<BurgerDto>> getBurgers() {
    return ResponseEntity.ok(this.burgerService.getBurgers());
  }

  @ApiOperation("Gets the ingredients of a particular burger by its ID")
  @ApiResponses({@ApiResponse(code = 404, message = "Not Found", response = ApiErrorDto.class)})
  @GetMapping("/{id}/ingredients")
  public ResponseEntity<List<IngredientDto>> getIngredientsByBurgerId(
      @ApiParam(value = "ID of the burger to query", required = true, example = "1") @PathVariable
          final Long id) {
    return ResponseEntity.ok(this.burgerService.getIngredientsByBurgerId(id));
  }
}
