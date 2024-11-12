package com.theakylino.librarysystem.repositories;

import com.theakylino.librarysystem.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
