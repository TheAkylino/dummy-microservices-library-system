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
import java.util.stream.Collectors;
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
  public PrestamoDTO crearPrestamo(PrestamoDTO prestamoDTO) {
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
  public Optional<PrestamoDTO> obtenerPrestamoById(Long id) {
    return prestamoRepository.findById(id)
        .map(prestamoMapper::toDTO);
  }

  @Override
  public PrestamoDTO actualizarPrestamo(Long id, PrestamoDTO prestamoDTO) {
    return obtenerPrestamoById(id)
        .map(existingPrestamo -> {
          existingPrestamo.setFechaPrestamo(prestamoDTO.getFechaPrestamo());
          existingPrestamo.setFechaDevolucion(prestamoDTO.getFechaDevolucion());
          existingPrestamo.setEstado(prestamoDTO.getEstado());
          var PrestamoActualizado = prestamoRepository.save(prestamoMapper.toEntity(existingPrestamo));
          return prestamoMapper.toDTO(PrestamoActualizado);
        })
        .orElseThrow(() -> new RuntimeException("Autor con ID " + id + " no encontrado."));
  }

  @Override
  public void borrarPrestamo(Long id) {
    prestamoRepository.deleteById(id);
  }

  @Override
  public List<PrestamoDTO> obtenerTodosPrestamos() {
    return prestamoRepository.findAll()
        .stream()
        .map(prestamoMapper::toDTO)
        .collect(Collectors.toList());
  }

  @Override
  public List<PrestamoDTO> listaPrestamosPorLibro(Long libroId) {
//    return prestamoRepository.buscarPorIdDeLibro(libroId)
//        .stream()
//        .map(prestamoMapper::toDTO)
//        .collect(Collectors.toList());
    return null;
  }
}
