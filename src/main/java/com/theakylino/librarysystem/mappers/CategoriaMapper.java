package com.theakylino.librarysystem.mappers;

import com.theakylino.librarysystem.dtos.CategoriaDTO;
import com.theakylino.librarysystem.entities.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

  CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

  CategoriaDTO toDTO(Categoria categoria);

  Categoria toEntity(CategoriaDTO categoriaDTO);
}

