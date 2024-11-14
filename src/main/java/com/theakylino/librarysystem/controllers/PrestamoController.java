package com.theakylino.librarysystem.controllers;


import com.theakylino.librarysystem.dtos.PrestamoDTO;
import com.theakylino.librarysystem.services.PrestamoService;
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
        .map(prestamoService::crearPrestamo)
        .map(autorCreadoDto -> ResponseEntity.status(HttpStatus.CREATED).body(autorCreadoDto))
        .orElseThrow(() -> new RuntimeException("Error creando un Autor"));
  }

  /**
   * Endpoint para listar todos los préstamos de un libro específico.
   *
   * Este método recupera todos los préstamos asociados a un libro específico utilizando su ID.
   *
   * @param libroId El ID del libro para el cual se desea obtener los préstamos.
   * @return Una ResponseEntity que contiene una lista de PrestamoDTO y el estado HTTP.
   */
  @Operation(summary = "Listar todos los préstamos de un libro",
      description = "Recupera todos los préstamos asociados a un libro específico utilizando su ID.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Préstamos listados exitosamente"),
          @ApiResponse(responseCode = "404", description = "Libro no encontrado"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @GetMapping("/prestamo/libro/{libroId}")
  public ResponseEntity<List<PrestamoDTO>> listaPrestamosLibros(@PathVariable Integer libroId) {
    List<PrestamoDTO> prestamos = prestamoService.listaPrestamosPorLibro(libroId);
    return ResponseEntity.ok(prestamos);
  }

  /**
   * Obtiene todos los préstamos del sistema.
   *
   * Este método recupera todos los préstamos almacenados en el sistema de biblioteca y los devuelve
   * en un formato adecuado.
   *
   * @return Una ResponseEntity que contiene una lista de PrestamoDTO y el estado HTTP.
   */
  @Operation(summary = "Obtener todos los préstamos",
      description = "Recupera todos los préstamos del sistema de biblioteca y "
          + "los devuelve en una lista de PrestamoDTO.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Préstamos recuperados exitosamente"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @GetMapping("/obtenerTodosPrestamo")
  public ResponseEntity<List<PrestamoDTO>> obtenerTodosPrestamo() {
    log.info("** BUSCANDO TODOS LOS PRÉSTAMOS **");
    return ResponseEntity.ok(prestamoService.obtenerTodosPrestamos());
  }

  /**
   * Obtiene un préstamo por su ID.
   *
   * Este método busca un préstamo en el sistema de biblioteca utilizando su ID y devuelve la
   * información del préstamo.
   *
   * @param id El ID del préstamo a buscar.
   * @return Una ResponseEntity que contiene el PrestamoDTO del préstamo encontrado y el estado HTTP.
   * @throws RuntimeException Si ocurre un error durante la búsqueda del préstamo.
   */
  @Operation(summary = "Obtener un préstamo por ID",
      description = "Busca un préstamo en el sistema de biblioteca utilizando su ID "
          + "y devuelve la información del préstamo.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Préstamo encontrado exitosamente"),
          @ApiResponse(responseCode = "404", description = "Préstamo no encontrado"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @GetMapping("/obtenerPrestamoPorId/{id}")
  public ResponseEntity<PrestamoDTO> obtenerPrestamoPorId(@PathVariable Integer id) {
    log.info("** BUSCANDO PRÉSTAMO POR ID **");
    return prestamoService.obtenerPrestamoById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }


  /**
   * Actualiza la información de un préstamo en el sistema.
   *
   * Este método busca un préstamo en el sistema de biblioteca utilizando su ID y actualiza la
   * información proporcionada en el objeto PrestamoDTO.
   *
   * @param id El ID del préstamo a actualizar.
   * @param prestamoDTO El objeto PrestamoDTO que contiene la información actualizada del préstamo.
   * @return Una ResponseEntity que contiene el PrestamoDTO del préstamo actualizado y el estado HTTP.
   * @throws RuntimeException Si ocurre un error durante la actualización del préstamo.
   */
  @Operation(summary = "Actualizar un préstamo por ID",
      description = "Busca un préstamo en el sistema de biblioteca utilizando su ID "
          + "y actualiza la información del préstamo.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Préstamo actualizado exitosamente"),
          @ApiResponse(responseCode = "404", description = "Préstamo no encontrado"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @PutMapping("/updatePrestamo/{id}")
  public ResponseEntity<PrestamoDTO> actualizarPrestamo(@PathVariable Integer id,
      @RequestBody @Valid PrestamoDTO prestamoDTO) {
    log.info("** ACTUALIZANDO PRÉSTAMO **");
    return Optional.of(prestamoDTO)
        .map(dto -> {
          dto.setId(id);
          return dto;
        })
        .map(updatePrestamo -> prestamoService.actualizarPrestamo(id, updatePrestamo))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }


  /**
   * Elimina un Prestamo del sistema.
   * <p>
   * Este método busca un Prestamo en el sistema de biblioteca utilizando su ID y, si se encuentra,
   * elimina el autor del sistema.
   *
   * @param id El ID del Prestamo a eliminar.
   * @return Una ResponseEntity con el estado HTTP correspondiente.
   * @throws RuntimeException Si ocurre un error durante la eliminación del autor.
   */
  @Operation(summary = "Eliminar un autor por ID",
      description = "Busca un autor en el sistema de biblioteca utilizando su ID y elimina el autor.",
      responses = {
          @ApiResponse(responseCode = "204", description = "Prestamo eliminado exitosamente"),
          @ApiResponse(responseCode = "404", description = "Prestamo no encontrado"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @DeleteMapping("/eliminarPrestamo/{id}")
  public ResponseEntity<Void> eliminarPrestamo(@PathVariable Integer id) {
    return prestamoService.obtenerPrestamoById(id)
        .map(autor -> {
          prestamoService.borrarPrestamo(id);
          return ResponseEntity.noContent().<Void>build();
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
