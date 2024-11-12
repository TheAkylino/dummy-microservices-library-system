package com.theakylino.librarysystem.mappers;

import com.theakylino.librarysystem.dtos.LibroDTO;
import com.theakylino.librarysystem.entities.Libro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class})
public interface LibroMapper {
  LibroMapper INSTANCE = Mappers.getMapper(LibroMapper.class);

  // Mapea solo el editorialId en lugar de un objeto completo de EditorialDTO
  @Mapping(target = "editorialId", source = "editorial.id")
  LibroDTO toDTO(Libro libro);

  // Mapea solo el editorialId a la entidad; el objeto Editorial se asignará en el servicio si es necesario
  @Mapping(target = "editorial.id", source = "editorialId")
  Libro toEntity(LibroDTO libroDTO);
}
