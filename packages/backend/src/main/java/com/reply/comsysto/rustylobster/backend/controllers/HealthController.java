package com.reply.comsysto.rustylobster.backend.controllers;

import com.reply.comsysto.rustylobster.backend.models.dtos.ServerStatusDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Health")
@RestController
@RequestMapping(value = "/api/health", produces = MediaType.APPLICATION_JSON_VALUE)
public class HealthController {
  @ApiOperation(
      "Returns a status code indicating that the server is still alive; otherwise, k8s will restart the pod")
  @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Object.class)})
  @GetMapping("/liveness")
  public ResponseEntity<?> getLiveness() {
    return ResponseEntity.ok().build();
  }

  @ApiOperation(
      "Returns a status code indicating whether the server is ready to receive request via k8s")
  @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Object.class)})
  @GetMapping("/readiness")
  public ResponseEntity<?> getReadiness() {
    return ResponseEntity.ok().build();
  }

  @ApiOperation("Returns a value indicating the status of the server")
  @GetMapping
  public ResponseEntity<ServerStatusDto> getServerStatus() {
    return ResponseEntity.ok(new ServerStatusDto("up"));
  }
}
