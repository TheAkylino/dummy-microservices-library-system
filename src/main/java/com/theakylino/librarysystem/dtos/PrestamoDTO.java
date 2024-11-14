package com.theakylino.librarysystem.dtos;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PrestamoDTO {

  private Integer id;

  @NotNull(message = "El fechaPrestamo no puede estar vacío")
  private LocalDate fechaPrestamo;

  @NotNull(message = "El fechaDevolucion no puede estar vacío")
  private LocalDate fechaDevolucion;

  @NotEmpty(message = "El estado no puede estar vacío")
  private String estado;

  @NotNull(message = "El libroId no puede estar vacío")
  private Integer libroId;
}
