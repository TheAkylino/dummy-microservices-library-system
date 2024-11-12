package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.entities.Categoria;
import com.theakylino.librarysystem.entities.Libro;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {

  List<Categoria> findAllCategorias();

  Optional<Categoria> findCategoriaById(Long id);

  Categoria createCategoria(Categoria categoria);

  Categoria updateCategoria(Categoria categoria);

  void deleteCategoria(Long id);

  List<Libro> findLibrosByCategoria(Long categoriaId);
}
