package com.theakylino.librarysystem.controllers;

import com.theakylino.librarysystem.dtos.AutorDTO;
import com.theakylino.librarysystem.services.AutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/api")
@Slf4j
public class AutorController {

  @Autowired
  private AutorService autorService;


  /**
   * Crea un nuevo autor en el sistema.
   *
   * @param autorDTO El objeto AutorDTO que contiene la información del autor a crear.
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
  @PostMapping("/crearAutor")
  public ResponseEntity<AutorDTO> addAutor(@RequestBody @Valid AutorDTO autorDTO) {
    log.info("** CREANDO AUTOR **");
    return Optional.of(autorDTO)
        .map(autorService::crearAutor)
        .map(autorCreadoDto -> ResponseEntity.status(HttpStatus.CREATED).body(autorCreadoDto))
        .orElseThrow(() -> new RuntimeException("Error creando un Autor"));
  }

  /**
   * Obtiene todos los autores del sistema.
   * <p>
   * Este método recupera todos los autores almacenados en el sistema de biblioteca y los devuelve
   * en un formato adecuado.
   *
   * @return Una ResponseEntity que contiene una lista de AutorDTO y el estado HTTP.
   */
  @Operation(summary = "Obtener todos los autores",
      description = "Recupera todos los autores del sistema de biblioteca "
          + "y los devuelve en una lista de AutorDTO.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Autores recuperados exitosamente"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @GetMapping("/getAllAutores")
  public ResponseEntity<List<AutorDTO>> getAllAutores() {
    log.info("** BUSCANDO TODOS LOS AUTORES **");
    List<AutorDTO> autores = autorService.obtenerTodosLosAutores();
    return ResponseEntity.ok(autores);
  }

  /**
   * Obtiene un autor por su ID.
   * <p>
   * Este método busca un autor en el sistema de biblioteca utilizando su ID y devuelve la
   * información del autor.
   *
   * @param id El ID del autor a buscar.
   * @return Una ResponseEntity que contiene el AutorDTO del autor encontrado y el estado HTTP.
   * @throws RuntimeException Si ocurre un error durante la búsqueda del autor.
   */
  @Operation(summary = "Obtener un autor por ID",
      description = "Busca un autor en el sistema de biblioteca utilizando su ID "
          + "y devuelve la información del autor.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Autor encontrado exitosamente"),
          @ApiResponse(responseCode = "404", description = "Autor no encontrado"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @GetMapping("/obtenerAutorPorId/{id}")
  public ResponseEntity<AutorDTO> obtenerAutorPorId(@PathVariable Integer id) {
    log.info("** BUSCANDO AUTOR POR ID **");
    return autorService.obtenerAutorPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  /**
   * Actualiza la información de un autor en el sistema.
   * <p>
   * Este método busca un autor en el sistema de biblioteca utilizando su ID y actualiza la
   * información proporcionada en el objeto AutorDTO.
   *
   * @param id       El ID del autor a actualizar.
   * @param autorDTO El objeto AutorDTO que contiene la información actualizada del autor.
   * @return Una ResponseEntity que contiene el AutorDTO del autor actualizado y el estado HTTP.
   * @throws RuntimeException Si ocurre un error durante la actualización del autor.
   */
  @Operation(summary = "Actualizar un autor por ID",
      description = "Busca un autor en el sistema de biblioteca utilizando "
          + "su ID y actualiza la información del autor.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Autor actualizado exitosamente"),
          @ApiResponse(responseCode = "404", description = "Autor no encontrado"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @PutMapping("/updateAutor/{id}")
  public ResponseEntity<AutorDTO> actualizarAutor(@PathVariable Integer id,
      @RequestBody @Valid AutorDTO autorDTO) {
    log.info("** ACTUALIZANDO AUTOR **");
    return Optional.of(autorDTO)
        .map(dto -> {
          dto.setId(id);
          return dto;
        })
        .map(updateAutor -> autorService.actualizarAutorPorId(id, updateAutor))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  /**
   * Elimina un autor del sistema.
   * <p>
   * Este método busca un autor en el sistema de biblioteca utilizando su ID y, si se encuentra,
   * elimina el autor del sistema.
   *
   * @param id El ID del autor a eliminar.
   * @return Una ResponseEntity con el estado HTTP correspondiente.
   * @throws RuntimeException Si ocurre un error durante la eliminación del autor.
   */
  @Operation(summary = "Eliminar un autor por ID",
      description = "Busca un autor en el sistema de biblioteca utilizando su ID y elimina el autor.",
      responses = {
          @ApiResponse(responseCode = "204", description = "Autor eliminado exitosamente"),
          @ApiResponse(responseCode = "404", description = "Autor no encontrado"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @DeleteMapping("/eliminarAutor/{id}")
  public ResponseEntity<Void> eliminarAutor(@PathVariable Integer id) {
    return autorService.obtenerAutorPorId(id)
        .map(autor -> {
          autorService.elimitarAutorPorId(id);
          return ResponseEntity.noContent().<Void>build();
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
