package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.entities.HistorialPrestamo;
import java.util.List;

public interface HistorialPrestamoService {

  List<HistorialPrestamo> findAllHistorialPrestamos();

  List<HistorialPrestamo> findByLibroId(Long libroId);
}
