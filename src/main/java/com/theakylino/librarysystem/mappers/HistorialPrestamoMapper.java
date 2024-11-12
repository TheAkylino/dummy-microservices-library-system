package com.theakylino.librarysystem.mappers;

import com.theakylino.librarysystem.dtos.HistorialPrestamoDTO;
import com.theakylino.librarysystem.entities.HistorialPrestamo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HistorialPrestamoMapper {

  HistorialPrestamoMapper INSTANCE = Mappers.getMapper(HistorialPrestamoMapper.class);

  // Mapea la propiedad "libro.id" de la entidad a "libroId" en el DTO
  @Mapping(target = "libroId", source = "libro.id")
  HistorialPrestamoDTO toDTO(HistorialPrestamo historialPrestamo);

  // Mapea la propiedad "libroId" del DTO a "libro.id" en la entidad
  // Debes asegurarte de asignar correctamente el libro en el servicio o repositorio
  @Mapping(target = "libro.id", source = "libroId")
  HistorialPrestamo toEntity(HistorialPrestamoDTO historialPrestamoDTO);
}