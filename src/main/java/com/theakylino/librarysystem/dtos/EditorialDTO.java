package com.theakylino.librarysystem.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditorialDTO {
  private Long id;
  private String nombre;
  private String direccion;
  private String telefono;
  private List<LibroDTO> libros;
}
