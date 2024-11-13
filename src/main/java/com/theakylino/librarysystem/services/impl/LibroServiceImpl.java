package com.theakylino.librarysystem.services.impl;

import com.theakylino.librarysystem.dtos.LibroDTO;
import com.theakylino.librarysystem.dtos.PrestamoDTO;
import com.theakylino.librarysystem.entities.Libro;
import com.theakylino.librarysystem.mappers.LibroMapper;
import com.theakylino.librarysystem.repositories.AutorRepository;
import com.theakylino.librarysystem.repositories.LibroRepository;
import com.theakylino.librarysystem.services.LibroService;
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
public class LibroServiceImpl  implements LibroService {

  @Value("${errorHandler.messages.errorCreateLibro}")
  private String mensajeError;

  @Autowired private LibroRepository libroRepository;
  @Autowired private AutorRepository autorRepository;
  @Autowired private LibroMapper libroMapper;


  @Override
  public LibroDTO createLibro(LibroDTO  libroDTO) {
    return Optional.of(libroDTO)
        .map(libroMapper::toEntity)
        .map(libro -> asignarAutor(libro, libroDTO.getAutorId()))
        .map(libroRepository::save)
        .map(libroMapper::toDTO)
        .orElseThrow(() -> new RuntimeException(mensajeError));
  }

  private Libro asignarAutor(Libro libro, Long autorId) {
    return autorRepository.findById(autorId)
        .map(autor -> {
          libro.setAutor(autor);
          return libro;
        })
        .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
  }

  @Override
  public Optional<LibroDTO> getLibroById(Long id) {
    return Optional.empty();
  }

  @Override
  public LibroDTO updateLibro(Long id, LibroDTO libroDTO) {
    return null;
  }

  @Override
  public void deleteLibro(Long id) {

  }

  @Override
  public List<LibroDTO> getAllLibros() {
    return List.of();
  }

  @Override
  public List<PrestamoDTO> getPrestamosByLibroId(Long libroId) {
    return List.of();
  }

  @Override
  public boolean isLibroDisponible(Long libroId) {
    return false;
  }

  @Override
  public List<LibroDTO> getAllLibrosPaginados(int page, int size) {
    return List.of();
  }
}
