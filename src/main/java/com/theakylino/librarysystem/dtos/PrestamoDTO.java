package com.theakylino.librarysystem.dtos;


import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PrestamoDTO {

  private Long id;
  private LocalDate fechaPrestamo;
  private LocalDate fechaDevolucion;
  private String estado;
  private Long libroId;
}
