package com.theakylino.librarysystem.mappers;

import com.theakylino.librarysystem.dtos.PrestamoDTO;
import com.theakylino.librarysystem.entities.Prestamo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PrestamoMapper {

  PrestamoMapper INSTANCE = Mappers.getMapper(PrestamoMapper.class);

  @Mapping(target = "libroId", source = "libro.id")
  PrestamoDTO toDTO(Prestamo prestamo);

  @Mapping(target = "libro", ignore = true)
  Prestamo toEntity(PrestamoDTO prestamoDTO);
}
