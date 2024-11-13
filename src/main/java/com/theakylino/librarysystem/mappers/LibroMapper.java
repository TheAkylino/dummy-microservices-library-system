package com.theakylino.librarysystem.mappers;

import com.theakylino.librarysystem.dtos.LibroDTO;
import com.theakylino.librarysystem.entities.Libro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LibroMapper {
  LibroMapper INSTANCE = Mappers.getMapper(LibroMapper.class);

  @Mapping(target = "autorId", source = "autor.id")
  LibroDTO toDTO(Libro libro);

  @Mapping(target = "autor", ignore = true)
  Libro toEntity(LibroDTO libroDTO);
}
