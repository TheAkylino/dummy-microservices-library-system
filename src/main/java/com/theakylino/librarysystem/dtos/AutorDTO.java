package com.theakylino.librarysystem.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class AutorDTO {

  private Integer id;

  @NotEmpty(message = "El nombre no puede estar vacío")
  @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
  private String nombre;

  @NotEmpty(message = "La nacionalidad no puede estar vacía")
  private String nacionalidad;

//  @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "El formato de la fecha debe ser YYYY-MM-DD")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate fechaNacimiento;
}
