package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.dtos.LibroDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface LibroService {

  LibroDTO crearLibro(LibroDTO  libroDTO);

  Optional<LibroDTO> obtenerLibroPorId(Integer  id);

  LibroDTO actualizarLibroPorId(Integer  id, LibroDTO libroDTO);

  void eliminarLibroPorId(Integer  id);

  List<LibroDTO> obtenerTodosLosLibros();

  boolean isLibrosDisponibles(Integer id);

  Page<LibroDTO> listadoLibrosPaginadosConCriterios(int page, int size);
}
