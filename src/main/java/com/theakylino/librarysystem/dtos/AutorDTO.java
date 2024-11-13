package com.theakylino.librarysystem.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class AutorDTO {

  private Long id;

  @NotEmpty(message = "El nombre no puede estar vacío")
  @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
  private String nombre;

  @NotEmpty(message = "La nacionalidad no puede estar vacía")
  private String nacionalidad;

  @NotEmpty(message = "La fecha de nacimiento no puede estar vacía")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$",
      message = "La fecha de nacimiento debe estar en el formato dd/MM/yyyy")
  private String fechaNacimiento;
}
