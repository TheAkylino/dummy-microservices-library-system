package com.theakylino.librarysystem.services.impl;

import com.theakylino.librarysystem.dtos.PrestamoDTO;
import com.theakylino.librarysystem.entities.Prestamo;
import com.theakylino.librarysystem.mappers.PrestamoMapper;
import com.theakylino.librarysystem.repositories.LibroRepository;
import com.theakylino.librarysystem.repositories.PrestamoRepository;
import com.theakylino.librarysystem.services.PrestamoService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Transactional
@Slf4j
public class PrestamoServiceImpl implements PrestamoService {

  @Value("${errorHandler.messages.errorCreatePrestamo}")
  private String mensajeError;

  @Autowired private PrestamoRepository prestamoRepository;
  @Autowired private LibroRepository libroRepository;
  @Autowired private PrestamoMapper prestamoMapper;


  @Override
  public PrestamoDTO createPrestamo(PrestamoDTO prestamoDTO) {
    return Optional.of(prestamoDTO)
        .map(prestamoMapper::toEntity)
        .map(prestamo -> asignarLibro(prestamo, prestamoDTO.getLibroId()))
        .map(prestamoRepository::save)
        .map(prestamoMapper::toDTO)
        .orElseThrow(() -> new RuntimeException(mensajeError));
  }

  private Prestamo asignarLibro(Prestamo prestamo, Long libroId) {
    return Optional.ofNullable(libroId)
        .flatMap(libroRepository::findById)
        .map(libro -> {
          prestamo.setLibro(libro);
          return prestamo;
        })
        .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
  }

  @Override
  public Optional<PrestamoDTO> getPrestamoById(Long id) {
    return Optional.empty();
  }

  @Override
  public PrestamoDTO updatePrestamo(Long id, PrestamoDTO prestamoDTO) {
    return null;
  }

  @Override
  public void deletePrestamo(Long id) {

  }

  @Override
  public List<PrestamoDTO> getAllPrestamos() {
    return List.of();
  }
}
