package com.theakylino.librarysystem.mappers;

import com.theakylino.librarysystem.dtos.AutorDTO;
import com.theakylino.librarysystem.entities.Autor;
import com.theakylino.librarysystem.entities.Libro;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {LibroMapper.class})
public interface AutorMapper {

  AutorMapper INSTANCE = Mappers.getMapper(AutorMapper.class);

  // Mapea solo los IDs de los libros en lugar de objetos completos de LibroDTO
  @Mapping(target = "libroIds", source = "libros")
  AutorDTO toDTO(Autor autor);

  @Mapping(target = "libros", ignore = true) // Para evitar problemas, maneja libros en el servicio
  Autor toEntity(AutorDTO autorDTO);

  // Método auxiliar para extraer solo los IDs de los libros
  default List<Long> mapLibrosToIds(Set<Libro> libros) {
    return libros != null ? libros.stream().map(Libro::getId).collect(Collectors.toList()) : null;
  }
}
