package com.theakylino.librarysystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LibroDTO {

  private Long id;
  private String titulo;
  private String isbn;
  private String fechaPublicacion;
  private String estado;
  private Long autorId;
}
