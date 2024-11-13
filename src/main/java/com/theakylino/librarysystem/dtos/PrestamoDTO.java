package com.theakylino.librarysystem.dtos;


import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PrestamoDTO {

  private Long id;

  @NotEmpty(message = "El fechaPrestamo no puede estar vacío")
  private LocalDate fechaPrestamo;

  @NotEmpty(message = "El fechaDevolucion no puede estar vacío")
  private LocalDate fechaDevolucion;

  @NotEmpty(message = "El estado no puede estar vacío")
  private String estado;

  @NotEmpty(message = "El libroId no puede estar vacío")
  private Long libroId;
}
