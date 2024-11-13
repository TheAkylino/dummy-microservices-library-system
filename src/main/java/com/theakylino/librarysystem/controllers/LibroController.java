package com.theakylino.librarysystem.controllers;

import com.theakylino.librarysystem.dtos.LibroDTO;
import com.theakylino.librarysystem.services.LibroService;
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
public class LibroController {

  @Autowired private LibroService libroService;

  /**
   * Endpoint para crear un nuevo libro en el sistema de biblioteca. Este método recibe un objeto
   * LibroDTO que contiene la información del libro a crear, incluyendo sus relaciones con autor,
   * editorial y categorías.
   *
   * @param libroDTO El objeto LibroDTO que contiene la información del libro a crear.
   * @return Una ResponseEntity que contiene el LibroDTO del libro creado y el estado HTTP.
   * @throws RuntimeException Si ocurre un error durante la creación del libro.
   */
  @Operation(summary = "Crear un nuevo libro",
      description = "Crea un nuevo libro en el sistema de biblioteca "
          + "y devuelve el libro creado, incluyendo relaciones con autor, editorial y categorías.",
      responses = {
          @ApiResponse(responseCode = "201", description = "Libro creado exitosamente"),
          @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @PostMapping("/createLibro")
  public ResponseEntity<LibroDTO> addLibro(@RequestBody @Valid LibroDTO libroDTO) {
    log.info("** CREANDO LIBRO **");
    return Optional.of(libroDTO)
        .map(libroService::createLibro)
        .map(libroCreadoDto -> ResponseEntity.status(HttpStatus.CREATED).body(libroCreadoDto))
        .orElseThrow(() -> new RuntimeException("Error creando el libro"));
  }
}
