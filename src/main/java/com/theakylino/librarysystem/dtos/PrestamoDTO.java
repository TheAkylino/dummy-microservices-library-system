package com.theakylino.librarysystem.dtos;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PrestamoDTO {
  private Long id;
  private Date fechaPrestamo;
  private Date fechaDevolucion;
  private String estado; // Activo / Finalizado
  private Long libroId;   // Solo el ID del libro
  private Long usuarioId; // Solo el ID del usuario
}
