package com.reply.comsysto.rustylobster.backend.controllers;

import com.reply.comsysto.rustylobster.backend.models.dtos.ApiErrorDto;
import com.reply.comsysto.rustylobster.backend.models.dtos.IngredientDto;
import com.reply.comsysto.rustylobster.backend.models.dtos.IngredientStockDto;
import com.reply.comsysto.rustylobster.backend.models.entities.IngredientCategory;
import com.reply.comsysto.rustylobster.backend.services.IngredientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Ingredients")
@RestController
@RequestMapping(value = "/api/ingredients", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class IngredientController {
  private final IngredientService ingredientService;

  @ApiOperation("Gets a particular ingredient using its ID")
  @ApiResponses({@ApiResponse(code = 404, message = "Not Found", response = ApiErrorDto.class)})
  @GetMapping("/{id}")
  public ResponseEntity<IngredientDto> getIngredientById(
      @ApiParam(value = "ID of the ingredient to query", required = true, example = "1")
          @PathVariable
          final Long id) {
    return ResponseEntity.ok(this.ingredientService.getIngredientById(id));
  }

  @ApiOperation("Returns the current stock quantity of a particular ingredient")
  @ApiResponses({@ApiResponse(code = 404, message = "Not Found", response = ApiErrorDto.class)})
  @GetMapping("/{id}/stock")
  public ResponseEntity<IngredientStockDto> getIngredientStockById(
      @ApiParam(value = "ID of the ingredient to query", required = true, example = "1")
          @PathVariable
          final Long id) {
    return ResponseEntity.ok(this.ingredientService.getIngredientStockById(id));
  }

  @ApiOperation("Returns a list of all known ingredients offered by the company")
  @GetMapping
  public ResponseEntity<List<IngredientDto>> getIngredients(
      @ApiParam(value = "Optional category to filter by", example = "Bread")
          @RequestParam(required = false)
          final IngredientCategory ingredientCategory) {
    return ResponseEntity.ok(this.ingredientService.getIngredients(ingredientCategory));
  }
}
