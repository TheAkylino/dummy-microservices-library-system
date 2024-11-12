package com.theakylino.librarysystem.repositories;

import com.theakylino.librarysystem.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
