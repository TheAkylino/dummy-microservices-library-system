package com.theakylino.librarysystem.repositories;

import com.theakylino.librarysystem.entities.Autor;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

  @Query("SELECT a FROM Autor a WHERE a.nombre = :nombre")
  Optional<Autor> buscarAutorPorTitulo(@Param("nombre") String nombre);
}
