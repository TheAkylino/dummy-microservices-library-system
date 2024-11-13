package com.theakylino.librarysystem.repositories;

import com.theakylino.librarysystem.entities.Libro;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LibroRepository extends JpaRepository<Libro, Long> {

  @Query("SELECT a FROM Libro a WHERE a.titulo = :titulo")
  Optional<Libro> buscarLibroPorNombre(@Param("titulo") String titulo);
}
