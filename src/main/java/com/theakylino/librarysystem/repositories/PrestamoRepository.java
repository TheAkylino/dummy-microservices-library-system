package com.theakylino.librarysystem.repositories;

import com.theakylino.librarysystem.entities.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

  //@Query("SELECT a FROM Prestamo a WHERE a.nombre = :nombre")
  //List<Prestamo> buscarPorIdDeLibro(Long libroId);
}
