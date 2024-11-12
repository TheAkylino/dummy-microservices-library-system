package com.theakylino.librarysystem.mappers;

import com.theakylino.librarysystem.dtos.ReservaDTO;
import com.theakylino.librarysystem.entities.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {LibroMapper.class})
public interface ReservaMapper {
  ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

  // Mapea solo usuarioId en lugar de un objeto completo UsuarioDTO
  @Mapping(target = "usuarioId", source = "usuario.id")
  ReservaDTO toDTO(Reserva reserva);

  // Mapea usuarioId a la entidad Reserva; asigna el objeto Usuario en el servicio si es necesario
  @Mapping(target = "usuario.id", source = "usuarioId")
  Reserva toEntity(ReservaDTO reservaDTO);
}
