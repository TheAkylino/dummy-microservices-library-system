package com.theakylino.librarysystem.services.impl;

import com.theakylino.librarysystem.entities.Categoria;
import com.theakylino.librarysystem.entities.Libro;
import com.theakylino.librarysystem.repositories.CategoriaRepository;
import com.theakylino.librarysystem.services.CategoriaService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Transactional
@Slf4j

public class CategoriaServiceImpl implements CategoriaService {

  @Value("${errorHandler.messages.errorCreateCategoria}")
  private String mensajeError;

  @Autowired private CategoriaRepository categoriaRepository;

  @Override
  public List<Categoria> findAllCategorias() {
    return List.of();
  }

  @Override
  public Optional<Categoria> findCategoriaById(final Long id) {
    return Optional.empty();
  }

  @Override
  public Categoria createCategoria(final Categoria categoria) {
    return Optional.of(categoria)
        .map(categoriaTosave -> categoriaRepository.save(categoriaTosave))
        .orElseThrow(
            () -> new RuntimeException(mensajeError));
  }

  @Override
  public Categoria updateCategoria(final Categoria categoria) {
    return null;
  }

  @Override
  public void deleteCategoria(final Long id) {

  }

  @Override
  public List<Libro> findLibrosByCategoria(final Long categoriaId) {
    return List.of();
  }
}
