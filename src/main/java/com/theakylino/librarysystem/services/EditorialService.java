package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.entities.Editorial;
import com.theakylino.librarysystem.entities.Libro;
import java.util.List;
import java.util.Optional;

public interface EditorialService {

  List<Editorial> findAllEditoriales();

  Optional<Editorial> findEditorialById(Long id);

  Editorial createEditorial(Editorial editorial);

  Editorial updateEditorial(Editorial editorial);

  void deleteEditorial(Long id);

  List<Libro> findLibrosByEditorial(Long editorialId);
}
