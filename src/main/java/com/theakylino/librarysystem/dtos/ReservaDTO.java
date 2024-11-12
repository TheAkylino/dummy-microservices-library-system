package com.theakylino.librarysystem.dtos;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReservaDTO {
  private Long id;
  private Date fechaReserva;
  private String estado; // Activa / Cancelada
  private Long libroId;   // Solo el ID del libro
  private Long usuarioId; // Solo el ID del usuario
}
