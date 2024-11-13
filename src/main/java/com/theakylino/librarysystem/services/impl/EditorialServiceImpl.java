package com.theakylino.librarysystem.services.impl;

import com.theakylino.librarysystem.entities.Editorial;
import com.theakylino.librarysystem.entities.Libro;
import com.theakylino.librarysystem.repositories.EditorialRepository;
import com.theakylino.librarysystem.services.EditorialService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Transactional
@Slf4j
public class EditorialServiceImpl implements EditorialService {

  @Value("${errorHandler.messages.errorCreateEditorial}")
  private String mensajeError;

  @Autowired private EditorialRepository editorialRepository;

  @Override
  public List<Editorial> findAllEditoriales() {
    return List.of();
  }

  @Override
  public Optional<Editorial> findEditorialById(final Long id) {
    return Optional.empty();
  }

  @Override
  public Editorial createEditorial(final Editorial editorial) {
    return Optional.of(editorial)
        .map(editorialTosave -> editorialRepository.save(editorialTosave))
        .orElseThrow(
            () -> new RuntimeException(mensajeError));
  }

  @Override
  public Editorial updateEditorial(final Editorial editorial) {
    return null;
  }

  @Override
  public void deleteEditorial(final Long id) {

  }

  @Override
  public List<Libro> findLibrosByEditorial(final Long editorialId) {
    return List.of();
  }
}
