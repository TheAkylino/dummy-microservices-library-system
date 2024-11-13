package com.theakylino.librarysystem.controllers;

import com.theakylino.librarysystem.dtos.EditorialDTO;
import com.theakylino.librarysystem.mappers.EditorialMapper;
import com.theakylino.librarysystem.services.EditorialService;
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
public class EditorialController {

  private EditorialService editorialService;
  private EditorialMapper editorialMapper;

  /**
   * Crea una nueva editorial en el sistema.
   *
   * @param editorialDTO El objeto EditorialDTO que contiene la información de la editorial a crear.
   * @return Una ResponseEntity que contiene el EditorialDTO de la editorial creada y el estado HTTP.
   * @throws RuntimeException Si ocurre un error durante la creación de la editorial.
   */
  @PostMapping("/createEditorial")
  public ResponseEntity<EditorialDTO> addEditorial(@RequestBody @Valid EditorialDTO editorialDTO){
    log.info(" ** CREANDO EDITORIAL **");
    return Optional.of(editorialDTO)
        .map(editorialMapper::toEntity)
        .map(editorialService::createEditorial)
        .map(entity -> editorialMapper.toDTO(entity))
        .map(editorialCreado -> ResponseEntity.status(HttpStatus.CREATED).body(editorialCreado))
        .orElseThrow(() -> new RuntimeException("Error creando un editorial"));
  }
}
