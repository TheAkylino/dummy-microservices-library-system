package com.theakylino.librarysystem.mappers;

import com.theakylino.librarysystem.dtos.EditorialDTO;
import com.theakylino.librarysystem.entities.Editorial;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {LibroMapper.class})
public interface EditorialMapper {

  EditorialMapper INSTANCE = Mappers.getMapper(EditorialMapper.class);

  @Mapping(target = "libros", source = "libros")
  EditorialDTO toDTO(Editorial editorial);

  @Mapping(target = "libros", source = "libros")
  Editorial toEntity(EditorialDTO editorialDTO);
}
