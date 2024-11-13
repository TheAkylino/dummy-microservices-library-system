package com.theakylino.librarysystem.controllers;

import com.theakylino.librarysystem.dtos.CategoriaDTO;
import com.theakylino.librarysystem.mappers.CategoriaMapper;
import com.theakylino.librarysystem.services.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/api")
@Slf4j
public class CategoriaController {

  private CategoriaService categoriaService;
  private CategoriaMapper editorialMapper;

  /**
   * Crea una nueva categoría en el sistema.
   * <p>
   * Este método recibe un objeto CategoriaDTO que contiene la información de la categoría a crear,
   * lo convierte en una entidad, la guarda en la base de datos y luego retorna el DTO de la
   * categoría creada.
   *
   * @param categoriaDTO El objeto CategoriaDTO que contiene la información de la categoría a
   *                     crear.
   * @return Una ResponseEntity que contiene el CategoriaDTO de la categoría creada y el estado
   * HTTP.
   * @throws RuntimeException Si ocurre un error durante la creación de la categoría.
   */
  @Operation(summary = "Crear una nueva categoría",
      description = "Crea una nueva categoría en el sistema "
          + "utilizando los datos proporcionados en el objeto CategoriaDTO.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Categoría creada exitosamente",
          content = @Content(schema = @Schema(implementation = CategoriaDTO.class))),
      @ApiResponse(responseCode = "400", description = "Solicitud inválida", content = @Content),
      @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
  })
  @PostMapping("/createCategoria")
  public ResponseEntity<CategoriaDTO> addCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO) {
    log.info(" ** CREANDO CATEGORIA **");
    return Optional.of(categoriaDTO)
        .map(dto -> editorialMapper.toEntity(dto))
        .map(categoriaService::createCategoria)
        .map(entity -> editorialMapper.toDTO(entity))
        .map(categoriaCreada -> ResponseEntity.status(HttpStatus.CREATED).body(categoriaCreada))
        .orElseThrow(() -> new RuntimeException("Error creando una categoría"));
  }
}
