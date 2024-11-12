package com.theakylino.librarysystem.mappers;
import com.theakylino.librarysystem.dtos.UsuarioDTO;
import com.theakylino.librarysystem.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {PrestamoMapper.class, ReservaMapper.class})
public interface UsuarioMapper {
  UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

  @Mapping(target = "prestamos", source = "prestamos")
  @Mapping(target = "reservas", source = "reservas")
  UsuarioDTO toDTO(Usuario usuario);

  @Mapping(target = "prestamos", source = "prestamos")
  @Mapping(target = "reservas", source = "reservas")
  Usuario toEntity(UsuarioDTO usuarioDTO);
}
