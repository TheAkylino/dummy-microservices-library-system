package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.dtos.PrestamoDTO;
import java.util.List;
import java.util.Optional;

public interface PrestamoService {

  PrestamoDTO createPrestamo(PrestamoDTO prestamoDTO);

  Optional<PrestamoDTO> getPrestamoById(Long id);

  PrestamoDTO updatePrestamo(Long id, PrestamoDTO prestamoDTO);

  void deletePrestamo(Long id);

  List<PrestamoDTO> getAllPrestamos();
}
