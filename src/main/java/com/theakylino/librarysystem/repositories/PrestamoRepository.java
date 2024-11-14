package com.theakylino.librarysystem.repositories;

import com.theakylino.librarysystem.entities.Prestamo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

  @Query("SELECT a FROM Prestamo a WHERE a.id = :id")
  List<Prestamo> buscarPrestamosPorLibroId(@Param("id") Integer id);
}
