package com.theakylino.librarysystem.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


@Setter
@Getter
public class AutorDTO {

  private Long id;

  @NotEmpty(message = "El nombre no puede estar vacío")
  @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
  private String nombre;

  @NotEmpty(message = "La nacionalidad no puede estar vacía")
  private String nacionalidad;

  @NotNull(message = "La fecha de nacimiento no puede ser nula")
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private String fechaNacimiento;
}
