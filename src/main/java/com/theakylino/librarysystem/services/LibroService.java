package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.dtos.LibroDTO;
import com.theakylino.librarysystem.dtos.PrestamoDTO;
import java.util.List;
import java.util.Optional;

public interface LibroService {

  LibroDTO createLibro(LibroDTO  libroDTO);

  Optional<LibroDTO> getLibroById(Long id);

  LibroDTO updateLibro(Long id, LibroDTO libroDTO);

  void deleteLibro(Long id);

  List<LibroDTO> getAllLibros();

  List<PrestamoDTO> getPrestamosByLibroId(Long libroId);

  boolean isLibroDisponible(Long libroId);

  List<LibroDTO> getAllLibrosPaginados(int page, int size);
}
