package com.theakylino.librarysystem.controllers;

import com.theakylino.librarysystem.dtos.LibroDTO;
import com.theakylino.librarysystem.entities.Libro;
import com.theakylino.librarysystem.mappers.LibroMapper;
import com.theakylino.librarysystem.services.LibroService;
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
public class LibroController {

  private final LibroService libroService;
  private final LibroMapper libroMapper;

  /**
   * Endpoint para crear un nuevo libro en el sistema de biblioteca. Este método recibe un objeto
   * LibroDTO que contiene la información del libro a crear, incluyendo sus relaciones con autor,
   * editorial y categorías.
   *
   * @param libroDTO El objeto LibroDTO que contiene la información del libro a crear.
   * @return Una ResponseEntity que contiene el LibroDTO del libro creado y el estado HTTP.
   */
  @PostMapping("/createLibro")
  public ResponseEntity<LibroDTO> addLibro(@RequestBody @Valid LibroDTO libroDTO) {
    log.info(" ** CREANDO LIBRO **");
    return Optional.of(libroDTO)
        .map(libroMapper::toEntity)
        .map(entity -> construyendoObjectLibro(entity, libroService, libroDTO))
        .map(libroMapper::toDTO)
        .map(libroCreado -> ResponseEntity.status(HttpStatus.CREATED).body(libroCreado))
        .orElseThrow(() -> new RuntimeException("Error creando el libro"));
  }

  /**
   * Método auxiliar para construir el objeto Libro con relaciones, como autor, editorial y categorías.
   *
   * @param entity El objeto Libro.
   * @param libroService El servicio para guardar el libro con sus relaciones.
   * @param dto El DTO que contiene los IDs de las relaciones.
   * @return El objeto Libro creado y persistido.
   */
  private Libro construyendoObjectLibro(final Libro entity,
      final LibroService libroService, final LibroDTO dto) {
    return Optional.of(entity)
        .map(entityObject -> libroService.createLibro(
            entityObject,
            dto.getAutorId(),
            dto.getEditorialId(),
            dto.getCategoriaIds()))
        .orElseThrow(() -> new RuntimeException("Hubo un error en construir el objeto libro"));
  }
}
