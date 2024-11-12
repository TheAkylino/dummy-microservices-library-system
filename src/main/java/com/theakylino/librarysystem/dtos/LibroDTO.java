package com.theakylino.librarysystem.dtos;

import java.sql.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LibroDTO {
  private Long id;
  private String titulo;
  private String isbn;
  private Date fechaPublicacion;
  private String estado;
  private Long autorId;   // Solo el ID del autor
  private Long editorialId; // Solo el ID de la editorial
  private List<CategoriaDTO> categorias;
}
