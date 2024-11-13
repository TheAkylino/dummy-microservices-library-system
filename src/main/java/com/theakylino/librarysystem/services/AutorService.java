package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.dtos.AutorDTO;
import java.util.List;
import java.util.Optional;

public interface AutorService {

  AutorDTO crearAutor(AutorDTO autorDTO);

  Optional<AutorDTO> obtenerAutorPorId(Long id);

  AutorDTO actualizarAutorPorId(Long id, AutorDTO autorDTO);

  void elimitarAutorPorId(Long id);

  List<AutorDTO> obtenerTodosLosAutores();
}
