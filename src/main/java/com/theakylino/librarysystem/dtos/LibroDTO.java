package com.theakylino.librarysystem.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LibroDTO {

  private Integer id;

  @NotEmpty(message = "El titulo no puede estar vacío")
  @Size(min = 2, max = 50, message = "El titulo debe tener entre 2 y 50 caracteres")
  private String titulo;

  @NotEmpty(message = "El isbn no puede estar vacío")
  private String isbn;

//  @NotNull
//  @NotEmpty(message = "El fechaPublicacion no puede estar vacío")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate fechaPublicacion;

  private String estado;

  private Integer autorId;
}
