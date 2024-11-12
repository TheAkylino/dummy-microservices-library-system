package com.theakylino.librarysystem.dtos;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioDTO {
  private Long id;
  private String nombre;
  private String email;
  private String telefono;
  private String direccion;
  private List<PrestamoDTO> prestamos;
  private List<ReservaDTO> reservas;
}
