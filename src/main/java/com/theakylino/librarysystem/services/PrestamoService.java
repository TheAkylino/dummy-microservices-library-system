package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.dtos.PrestamoDTO;
import java.util.List;
import java.util.Optional;

public interface PrestamoService {

  PrestamoDTO crearPrestamo(PrestamoDTO prestamoDTO);

  Optional<PrestamoDTO> obtenerPrestamoById(Integer id);

  PrestamoDTO actualizarPrestamo(Integer  id, PrestamoDTO prestamoDTO);

  void borrarPrestamo(Integer id);

  List<PrestamoDTO> obtenerTodosPrestamos();

  List<PrestamoDTO> listaPrestamosPorLibro(Integer  libroId);
}
