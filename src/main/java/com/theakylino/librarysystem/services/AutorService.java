package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.entities.Autor;
import com.theakylino.librarysystem.entities.Libro;
import java.util.List;
import java.util.Optional;

public interface AutorService {

  List<Autor> findAllAutores();

  Optional<Autor> findAutorById(Long id);

  Autor createAutor(Autor autor);

  Autor updateAutor(Autor autor);

  void deleteAutor(Long id);

  List<Libro> findLibrosByAutor(Long autorId);
}
