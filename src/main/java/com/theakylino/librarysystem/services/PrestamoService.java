package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.dtos.PrestamoDTO;
import java.util.List;
import java.util.Optional;

public interface PrestamoService {

  PrestamoDTO crearPrestamo(PrestamoDTO prestamoDTO);

  Optional<PrestamoDTO> obtenerPrestamoById(Long id);

  PrestamoDTO actualizarPrestamo(Long id, PrestamoDTO prestamoDTO);

  void borrarPrestamo(Long id);

  List<PrestamoDTO> obtenerTodosPrestamos();

  List<PrestamoDTO> listaPrestamosPorLibro(Long libroId);
}
