package com.theakylino.librarysystem.mappers;

import com.theakylino.librarysystem.dtos.AutorDTO;
import com.theakylino.librarysystem.entities.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AutorMapper {

  AutorMapper INSTANCE = Mappers.getMapper(AutorMapper.class);

  AutorDTO toDTO(Autor autor);

  Autor toEntity(AutorDTO autorDTO);
}
