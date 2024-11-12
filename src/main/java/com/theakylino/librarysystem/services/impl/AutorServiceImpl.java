package com.theakylino.librarysystem.services.impl;

import com.theakylino.librarysystem.entities.Autor;
import com.theakylino.librarysystem.entities.Libro;
import com.theakylino.librarysystem.repositories.AutorRepository;
import com.theakylino.librarysystem.services.AutorService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Transactional
@Slf4j
@AllArgsConstructor
public class AutorServiceImpl implements AutorService {

  private  AutorRepository autorRepository;


  @Override
  public List<Autor> findAllAutores() {
    return List.of();
  }

  @Override
  public Optional<Autor> findAutorById(final Long id) {
    return Optional.empty();
  }

  @Override
  public Autor createAutor(final Autor autor) {
    return Optional.of(autor)
        .map(autorToSave -> autorRepository.save(autorToSave))
        .orElseThrow(() -> new RuntimeException("Error creando un Autor"));
  }

  @Override
  public Autor updateAutor(final Autor autor) {
    return null;
  }

  @Override
  public void deleteAutor(final Long id) {

  }

  @Override
  public List<Libro> findLibrosByAutor(final Long autorId) {
    return List.of();
  }
}
