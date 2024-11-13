package com.theakylino.librarysystem.services.impl;

import com.theakylino.librarysystem.entities.HistorialPrestamo;
import com.theakylino.librarysystem.entities.Libro;
import com.theakylino.librarysystem.entities.Prestamo;
import com.theakylino.librarysystem.entities.Reserva;
import com.theakylino.librarysystem.repositories.LibroRepository;
import com.theakylino.librarysystem.services.LibroService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
@Slf4j
public class LibroServiceImpl  implements LibroService {

  @Autowired private LibroRepository libroRepository;

  @Override
  public List<Libro> findAllLibros() {
    return List.of();
  }

  @Override
  public Optional<Libro> findLibroById(Long id) {
    return Optional.empty();
  }

  @Override
  public Libro createLibro(Libro libro, Long autorId, Long editorialId, Set<Long> categoriaIds) {
    return Optional.of(libro)
        .map(librolTosave -> libroRepository.save(librolTosave))
        .orElseThrow(() -> new RuntimeException("Ha ocurrido un error creando el libro."));
  }

  @Override
  public Libro updateLibro(Libro libro) {
    return null;
  }

  @Override
  public void deleteLibro(Long id) {

  }

  @Override
  public boolean isLibroDisponible(Long libroId) {
    return false;
  }

  @Override
  public List<Prestamo> findPrestamosByLibro(Long libroId) {
    return List.of();
  }

  @Override
  public List<Reserva> findReservasByLibro(Long libroId) {
    return List.of();
  }

  @Override
  public List<HistorialPrestamo> findHistorialPrestamosByLibro(Long libroId) {
    return List.of();
  }
}
