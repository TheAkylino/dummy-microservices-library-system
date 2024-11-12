package com.theakylino.librarysystem.dtos;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HistorialPrestamoDTO {
  private Long id;
  private Date fechaPrestamo;
  private Date fechaDevolucion;
  private String estado; // Completo / Incompleto
  private Long libroId;
}
