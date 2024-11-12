package com.theakylino.librarysystem.controllers;

import com.theakylino.librarysystem.dtos.AutorDTO;
import com.theakylino.librarysystem.mappers.AutorMapper;
import com.theakylino.librarysystem.services.AutorService;
import jakarta.validation.Valid;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/api")
@Slf4j
public class AutorController {

  private AutorService autorService;
  private AutorMapper autorMapper;

  /**
   * Crea un nuevo autor en el sistema.
   *
   * @param autorDTO El objeto AutorDTO que contiene la información del autor a crear.
   * @return La ResponseEntity que contiene el AutorDTO del autor creado y el estado HTTP.
   * @throws RuntimeException Si ocurre un error durante la creación del autor.
   */
  @PostMapping("/createAutor")
  public ResponseEntity<AutorDTO> addAutor(@RequestBody @Valid AutorDTO autorDTO) {
    log.info(" ** CREANDO AUTOR **");
    return Optional.of(autorDTO)
        .map(dto -> autorMapper.toEntity(dto))
        .map(autorService::createAutor)
        .map(entity -> autorMapper.toDTO(entity))
        .map(autorCreado -> ResponseEntity.status(HttpStatus.CREATED).body(autorCreado))
        .orElseThrow(() -> new RuntimeException("Error creando un Autor"));
  }
}
