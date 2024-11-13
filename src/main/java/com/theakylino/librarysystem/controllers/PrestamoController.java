package com.theakylino.librarysystem.controllers;


import com.theakylino.librarysystem.dtos.PrestamoDTO;
import com.theakylino.librarysystem.services.PrestamoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/api")
@Slf4j
public class PrestamoController {

  @Autowired private PrestamoService prestamoService;

  /**
   * Crea un nuevo autor en el sistema.
   *
   * @param prestamoDTO El objeto AutorDTO que contiene la información del autor a crear.
   * @return La ResponseEntity que contiene el AutorDTO del autor creado y el estado HTTP.
   * @throws RuntimeException Si ocurre un error durante la creación del autor.
   */
  @Operation(summary = "Crear un nuevo autor",
      description = "Crea un nuevo autor en el sistema y devuelve el autor creado.",
      responses = {
          @ApiResponse(responseCode = "201", description = "Autor creado exitosamente"),
          @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @PostMapping("/createPrestamo")
  public ResponseEntity<PrestamoDTO> addPrestamo(@RequestBody @Valid PrestamoDTO prestamoDTO) {
    log.info("** CREANDO AUTOR **");
    return Optional.of(prestamoDTO)
        .map(prestamoService::createPrestamo)
        .map(autorCreadoDto -> ResponseEntity.status(HttpStatus.CREATED).body(autorCreadoDto))
        .orElseThrow(() -> new RuntimeException("Error creando un Autor"));
  }
}
