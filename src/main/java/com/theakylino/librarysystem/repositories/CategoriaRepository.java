package com.theakylino.librarysystem.repositories;

import com.theakylino.librarysystem.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
