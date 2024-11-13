package com.theakylino.librarysystem.dtos;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoriaDTO {

  private UUID id;
  private String nombre;
  private String descripcion;
}
