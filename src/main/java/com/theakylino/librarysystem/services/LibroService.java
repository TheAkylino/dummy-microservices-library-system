package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.dtos.LibroDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface LibroService {

  LibroDTO crearLibro(LibroDTO  libroDTO);

  Optional<LibroDTO> obtenerLibroPorId(Long id);

  LibroDTO actualizarLibroPorId(Long id, LibroDTO libroDTO);

  void eliminarLibroPorId(Long id);

  List<LibroDTO> obtenerTodosLosLibros();

  boolean isLibrosDisponibles(Long id);

  Page<LibroDTO> listadoLibrosPaginadosConCriterios(int page, int size);
}
