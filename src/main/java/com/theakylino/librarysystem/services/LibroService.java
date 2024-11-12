package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.entities.HistorialPrestamo;
import com.theakylino.librarysystem.entities.Libro;
import com.theakylino.librarysystem.entities.Prestamo;
import com.theakylino.librarysystem.entities.Reserva;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface LibroService {

  List<Libro> findAllLibros();

  Optional<Libro> findLibroById(Long id);

  Libro createLibro(Libro libro, Long autorId, Long editorialId, Set<Long> categoriaIds);

  Libro updateLibro(Libro libro);

  void deleteLibro(Long id);

  boolean isLibroDisponible(Long libroId);

  List<Prestamo> findPrestamosByLibro(Long libroId);

  List<Reserva> findReservasByLibro(Long libroId);

  List<HistorialPrestamo> findHistorialPrestamosByLibro(Long libroId);
}
