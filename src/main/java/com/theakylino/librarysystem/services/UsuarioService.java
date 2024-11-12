package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.entities.Prestamo;
import com.theakylino.librarysystem.entities.Reserva;
import com.theakylino.librarysystem.entities.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

  List<Usuario> findAllUsuarios();

  Optional<Usuario> findUsuarioById(Long id);

  Usuario createUsuario(Usuario usuario);

  Usuario updateUsuario(Usuario usuario);

  void deleteUsuario(Long id);

  List<Prestamo> findPrestamosByUsuario(Long usuarioId);

  List<Reserva> findReservasByUsuario(Long usuarioId);
}
