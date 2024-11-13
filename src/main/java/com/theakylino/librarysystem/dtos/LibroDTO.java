package com.theakylino.librarysystem.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LibroDTO {

  private Long id;

  @NotEmpty(message = "El titulo no puede estar vacío")
  @Size(min = 2, max = 50, message = "El titulo debe tener entre 2 y 50 caracteres")
  private String titulo;

  @NotEmpty(message = "El isbn no puede estar vacío")
  private String isbn;

  @NotEmpty(message = "El fechaPublicacion no puede estar vacío")
  private String fechaPublicacion;

  @NotEmpty(message = "El estado no puede estar vacío")
  private String estado;

  private Long autorId;
}
