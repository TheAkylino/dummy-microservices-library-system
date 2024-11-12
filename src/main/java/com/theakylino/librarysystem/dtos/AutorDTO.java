package com.theakylino.librarysystem.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.util.List;
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
//  @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private String fechaNacimiento;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private List<Long> libroIds;
}
