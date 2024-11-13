package com.theakylino.librarysystem.mappers;

import com.theakylino.librarysystem.dtos.PrestamoDTO;
import com.theakylino.librarysystem.entities.Prestamo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PrestamoMapper {

  PrestamoMapper INSTANCE = Mappers.getMapper(PrestamoMapper.class);

  // Mapeo de Prestamo a PrestamoDTO
  @Mapping(target = "libroId", source = "libro.id")
  PrestamoDTO toDTO(Prestamo prestamo);

  // Mapeo de PrestamoDTO a Prestamo
  @Mapping(target = "libro", ignore = true)  // Se maneja en el servicio
  Prestamo toEntity(PrestamoDTO prestamoDTO);
}
