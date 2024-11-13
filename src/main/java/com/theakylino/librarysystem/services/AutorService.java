package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.dtos.AutorDTO;
import java.util.List;
import java.util.Optional;

public interface AutorService {

  AutorDTO crearAutor(AutorDTO autorDTO);

  Optional<AutorDTO> getAutorById(Long id);

  AutorDTO  updateAutor(Long id, AutorDTO autorDTO);

  void deleteAutor(Long id);

  List<AutorDTO> getAllAutores();
}
