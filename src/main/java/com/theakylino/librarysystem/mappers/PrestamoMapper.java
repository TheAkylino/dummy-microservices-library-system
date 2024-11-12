package com.theakylino.librarysystem.mappers;

import com.theakylino.librarysystem.dtos.PrestamoDTO;
import com.theakylino.librarysystem.entities.Prestamo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {LibroMapper.class})
public interface PrestamoMapper {
  PrestamoMapper INSTANCE = Mappers.getMapper(PrestamoMapper.class);

  // Mapea solo el usuarioId en lugar de un objeto completo de UsuarioDTO
  @Mapping(target = "usuarioId", source = "usuario.id")
  PrestamoDTO toDTO(Prestamo prestamo);

  // Mapea solo el usuarioId en el DTO a la propiedad usuario en la entidad
  // Se asignará el objeto Usuario completo en el servicio si es necesario
  @Mapping(target = "usuario.id", source = "usuarioId")
  Prestamo toEntity(PrestamoDTO prestamoDTO);
}
