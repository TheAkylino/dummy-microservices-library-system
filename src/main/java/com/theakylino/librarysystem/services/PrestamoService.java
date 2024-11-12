package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.entities.Prestamo;
import java.util.List;
import java.util.Optional;

public interface PrestamoService {

  List<Prestamo> findAllPrestamos();

  Optional<Prestamo> findPrestamoById(Long id);

  Prestamo createPrestamo(Long libroId, Long usuarioId, Prestamo prestamo);

  Prestamo updatePrestamo(Prestamo prestamo);

  void deletePrestamo(Long id);

  List<Prestamo> findActivePrestamosByUsuario(Long usuarioId);
}
