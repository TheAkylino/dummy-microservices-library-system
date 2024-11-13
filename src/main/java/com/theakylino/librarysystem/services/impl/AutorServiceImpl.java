package com.theakylino.librarysystem.services.impl;

import com.theakylino.librarysystem.dtos.AutorDTO;
import com.theakylino.librarysystem.mappers.AutorMapper;
import com.theakylino.librarysystem.repositories.AutorRepository;
import com.theakylino.librarysystem.services.AutorService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Transactional
@Slf4j
public class AutorServiceImpl implements AutorService {

  @Value("${errorHandler.messages.errorCreateAutor}")
  private String mensajeError;

  @Autowired
  private AutorRepository autorRepository;
  @Autowired
  private AutorMapper autorMapper;


  @Override
  public AutorDTO crearAutor(AutorDTO autorDTO) {
    return Optional.of(ValidateExistenceAuthorByName(autorDTO))
        .map(autorMapper::toEntity)
        .map(autorRepository::save)
        .map(autorMapper::toDTO)
        .orElseThrow(() -> new RuntimeException(mensajeError));
  }

  private AutorDTO ValidateExistenceAuthorByName(AutorDTO autorDTO) {
    autorRepository.buscarAutorPorTitulo(autorDTO.getNombre())
        .ifPresent(autor -> {
          throw new RuntimeException("El autor con el nombre '"
              + autorDTO.getNombre() + "' ya existe.");
        });
    return autorDTO;
  }

  @Override
  public Optional<AutorDTO> obtenerAutorPorId(Long id) {
    return autorRepository.findById(id)
        .map(autorMapper::toDTO);
  }

  @Override
  public AutorDTO actualizarAutorPorId(Long id, AutorDTO autorDTO) {
    return obtenerAutorPorId(id)
        .map(existingAutor -> {
          existingAutor.setNombre(autorDTO.getNombre());
          existingAutor.setNacionalidad(autorDTO.getNacionalidad());
          existingAutor.setFechaNacimiento(autorDTO.getFechaNacimiento());
          var autorActualizado = autorRepository.save(autorMapper.toEntity(existingAutor));
          return autorMapper.toDTO(autorActualizado);
        })
        .orElseThrow(() -> new RuntimeException("Autor con ID " + id + " no encontrado."));
  }

  @Override
  public void elimitarAutorPorId(Long id) {
    autorRepository.deleteById(id);
  }

  @Override
  public List<AutorDTO> obtenerTodosLosAutores() {
    return autorRepository.findAll()
        .stream()
        .map(autorMapper::toDTO)
        .collect(Collectors.toList());
  }
}
