package com.theakylino.librarysystem.dtos;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EditorialDTO {
  private Long id;
  private String nombre;
  private String direccion;
  private String telefono;
  private List<LibroDTO> libros;
}
