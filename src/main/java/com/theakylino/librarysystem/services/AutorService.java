package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.dtos.AutorDTO;
import java.util.List;
import java.util.Optional;

public interface AutorService {

  AutorDTO crearAutor(AutorDTO autorDTO);

  Optional<AutorDTO> obtenerAutorPorId(Integer  id);

  AutorDTO actualizarAutorPorId(Integer  id, AutorDTO autorDTO);

  void elimitarAutorPorId(Integer id);

  List<AutorDTO> obtenerTodosLosAutores();
}
