package com.theakylino.librarysystem.services;

import com.theakylino.librarysystem.entities.Reserva;
import java.util.List;
import java.util.Optional;

public interface ReservaService {

  List<Reserva> findAllReservas();

  Optional<Reserva> findReservaById(Long id);

  Reserva createReserva(Long libroId, Long usuarioId, Reserva reserva);

  Reserva updateReserva(Reserva reserva);

  void deleteReserva(Long id);

  List<Reserva> findActiveReservasByUsuario(Long usuarioId);
}
