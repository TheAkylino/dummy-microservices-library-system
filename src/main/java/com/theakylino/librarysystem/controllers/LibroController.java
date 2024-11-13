package com.theakylino.librarysystem.controllers;

import com.theakylino.librarysystem.dtos.LibroDTO;
import com.theakylino.librarysystem.services.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        .map(libroService::crearLibro)
        .map(libroCreadoDto -> ResponseEntity.status(HttpStatus.CREATED).body(libroCreadoDto))
        .orElseThrow(() -> new RuntimeException("Error creando el libro"));
  }

  /**
   * Obtiene todos los libros del sistema.
   * <p>
   * Este método recupera todos los libros almacenados en el sistema de biblioteca y los devuelve
   * en un formato adecuado.
   *
   * @return Una ResponseEntity que contiene una lista de AutorDTO y el estado HTTP.
   */
  @Operation(summary = "Obtener todos los libros",
      description = "Recupera todos los libros del sistema de biblioteca "
          + "y los devuelve en una lista de libroDTO.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Libros recuperados exitosamente"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @GetMapping("/getAllLibros")
  public ResponseEntity<List<LibroDTO>> getAllAutores() {
    log.info("** BUSCANDO TODOS LOS LIBROS **");
    return ResponseEntity.ok(libroService.obtenerTodosLosLibros());
  }

  /**
   * Obtiene un libro por su ID.
   * <p>
   * Este método busca un libro en el sistema de biblioteca utilizando su ID y devuelve la
   * información del autor.
   *
   * @param id El ID del autor a buscar.
   * @return Una ResponseEntity que contiene el AutorDTO del autor encontrado y el estado HTTP.
   * @throws RuntimeException Si ocurre un error durante la búsqueda del autor.
   */
  @Operation(summary = "Obtener un libro por ID",
      description = "Busca un libro en el sistema de biblioteca utilizando su ID "
          + "y devuelve la información del libro.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Libro encontrado exitosamente"),
          @ApiResponse(responseCode = "404", description = "Libro no encontrado"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @GetMapping("/obtenerLibroPorId/{id}")
  public ResponseEntity<LibroDTO> obtenerLibroPorId(@PathVariable Long id) {
    log.info("** BUSCANDO LiBRO POR ID **");
    return libroService.obtenerLibroPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  /**
   * Actualiza la información de un libro en el sistema.
   * <p>
   * Este método busca un libro en el sistema de biblioteca utilizando su ID y actualiza la
   * información proporcionada en el objeto LibroDTO.
   *
   * @param id       El ID del libro a actualizar.
   * @param libroDTO El objeto LibroDTO que contiene la información actualizada del libro.
   * @return Una ResponseEntity que contiene el LibroDTO del libro actualizado y el estado HTTP.
   * @throws RuntimeException Si ocurre un error durante la actualización del libro.
   */
  @Operation(summary = "Actualizar un libro por ID",
      description = "Busca un libro en el sistema de biblioteca utilizando "
          + "su ID y actualiza la información del libro.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Autor actualizado exitosamente"),
          @ApiResponse(responseCode = "404", description = "Autor no encontrado"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @PutMapping("/updateLibro/{id}")
  public ResponseEntity<LibroDTO> actualizarLibro(@PathVariable Long id,
      @RequestBody @Valid LibroDTO libroDTO) {
    log.info("** ACTUALIZANDO LIBRO **");
    return Optional.of(libroDTO)
        .map(dto -> {
          dto.setId(id);
          return dto;
        })
        .map(updateLibro -> libroService.actualizarLibroPorId(id, updateLibro))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  /**
   * Elimina un libro del sistema.
   * <p>
   * Este método busca un libro en el sistema de biblioteca utilizando su ID y, si se encuentra,
   * elimina el libro del sistema.
   *
   * @param id El ID del libro a eliminar.
   * @return Una ResponseEntity con el estado HTTP correspondiente.
   * @throws RuntimeException Si ocurre un error durante la eliminación del libro.
   */
  @Operation(summary = "Eliminar un libro por ID",
      description = "Busca un autor en el sistema de biblioteca utilizando su ID y elimina el autor.",
      responses = {
          @ApiResponse(responseCode = "204", description = "libro eliminado exitosamente"),
          @ApiResponse(responseCode = "404", description = "libro no encontrado"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @DeleteMapping("/eliminarLibro/{id}")
  public ResponseEntity<Void> eliminarAutor(@PathVariable Long id) {
    return libroService.obtenerLibroPorId(id)
        .map(libro -> {
          libroService.eliminarLibroPorId(id);
          return ResponseEntity.noContent().<Void>build();
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  /**
   * Verifica la disponibilidad de un libro.
   *
   * Este método verifica si un libro está disponible en el sistema de biblioteca utilizando su ID.
   *
   * @param id El ID del libro a verificar.
   * @return Una ResponseEntity que contiene un valor booleano indicando
   * la disponibilidad del libro y el estado HTTP.
   */
  @Operation(summary = "Verificar disponibilidad de un libro",
      description = "Verifica si un libro está disponible en el sistema de biblioteca utilizando su ID.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Disponibilidad verificada exitosamente"),
          @ApiResponse(responseCode = "404", description = "Libro no encontrado"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @GetMapping("/disponibilidadLibro/{id}")
  public ResponseEntity<Boolean> verificarDisponibilidad(@PathVariable Long id) {
    boolean disponibilidad = libroService.isLibrosDisponibles(id);
    return ResponseEntity.ok(disponibilidad);
  }

  /**
   * Lista los libros paginados.
   *
   * Este método recupera una página de libros del sistema de biblioteca
   * según los criterios de paginación proporcionados.
   *
   * @param page El número de página a recuperar (valor por defecto es 0).
   * @param size El número de elementos por página (valor por defecto es 10).
   * @return Una ResponseEntity que contiene una página de LibroDTO y el estado HTTP.
   */
  @Operation(summary = "Listar libros paginados",
      description = "Recupera una página de libros del sistema de biblioteca"
          + " según los criterios de paginación proporcionados.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Libros listados exitosamente"),
          @ApiResponse(responseCode = "500", description = "Error interno del servidor")
      })
  @GetMapping("/listBooksPaged")
  public ResponseEntity<Page<LibroDTO>> listBooksPaged(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {
    return ResponseEntity.ok(libroService.listadoLibrosPaginadosConCriterios(page, size));
  }
}
