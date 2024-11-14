package com.theakylino.librarysystem.services.impl;

import com.theakylino.librarysystem.dtos.LibroDTO;
import com.theakylino.librarysystem.entities.Libro;
import com.theakylino.librarysystem.mappers.LibroMapper;
import com.theakylino.librarysystem.repositories.AutorRepository;
import com.theakylino.librarysystem.repositories.LibroRepository;
import com.theakylino.librarysystem.services.LibroService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@Transactional
@Slf4j
public class LibroServiceImpl implements LibroService {

  @Value("${errorHandler.messages.errorCreateLibro}")
  private String mensajeError;

  @Autowired private LibroRepository libroRepository;
  @Autowired private AutorRepository autorRepository;
  @Autowired private LibroMapper libroMapper;

  @PersistenceContext private EntityManager entityManager;

  public static final String AVAILABLE = "Disponible";

  @Override
  public LibroDTO crearLibro(LibroDTO libroDTO) {
    return Optional.of(ValidateExistenceAuthorByName(libroDTO))
        .map(libroMapper::toEntity)
        .map(libro -> asignarAutor(libro, libroDTO.getAutorId()))
        .map(libroRepository::save)
        .map(libroMapper::toDTO)
        .orElseThrow(() -> new RuntimeException(mensajeError));
  }

  private LibroDTO ValidateExistenceAuthorByName(LibroDTO libroDTO) {
    libroRepository.buscarLibroPorNombre(libroDTO.getTitulo())
        .ifPresent(title -> {
          throw new RuntimeException("El titulo del libro '"
              + libroDTO.getTitulo() + "' ya existe.");
        });
    return libroDTO;
  }

  private Libro asignarAutor(Libro libro, Integer  autorId) {
    return autorRepository.findById(autorId)
        .map(autor -> {
          libro.setAutor(autor);
          return libro;
        })
        .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
  }

  @Override
  public Optional<LibroDTO> obtenerLibroPorId(Integer  id) {
    return libroRepository.findById(id)
        .map(libroMapper::toDTO);
  }

  @Override
  public LibroDTO actualizarLibroPorId(Integer  id, LibroDTO libroDTO) {
    return obtenerLibroPorId(id)
        .map(existingLibro -> {
          existingLibro.setTitulo(libroDTO.getTitulo());
          existingLibro.setIsbn(libroDTO.getIsbn());
          existingLibro.setFechaPublicacion(libroDTO.getFechaPublicacion());
          existingLibro.setEstado(libroDTO.getEstado());
          var libroActualizado = libroRepository.save(libroMapper.toEntity(existingLibro));
          return libroMapper.toDTO(libroActualizado);
        })
        .orElseThrow(() -> new RuntimeException("Autor con ID " + id + " no encontrado."));
  }

  @Override
  public void eliminarLibroPorId(Integer  id) {
    libroRepository.deleteById(id);
  }

  @Override
  public List<LibroDTO> obtenerTodosLosLibros() {
    return libroRepository.findAll()
        .stream()
        .map(libroMapper::toDTO)
        .collect(Collectors.toList());
  }

  @Override
  public boolean isLibrosDisponibles(Integer  id) {
    return libroRepository.findById(id)
        .map(libro -> AVAILABLE.equalsIgnoreCase(libro.getEstado()))
        .orElse(false);
  }

  @Override
  public Page<LibroDTO> listadoLibrosPaginadosConCriterios(int page, int size) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Libro> cq = cb.createQuery(Libro.class);
    Root<Libro> libroRoot = cq.from(Libro.class);

    // Construir la consulta (puedes agregar filtros aquí si los necesitas)
    cq.select(libroRoot);

    // Crear la consulta tipada
    TypedQuery<Libro> query = entityManager.createQuery(cq);

    // Configurar paginación
    query.setFirstResult(page * size);
    query.setMaxResults(size);

    // Obtener el resultado de la página solicitada
    List<Libro> libros = query.getResultList();

    // Convertir a DTO (puedes usar un mapper si tienes uno configurado)
    List<LibroDTO> libroDTOs = libros.stream()
        .map(libroMapper::toDTO)
        .toList();

    // Obtener el conteo total para configurar la paginación correctamente
    long total = getTotalCount(cb);

    // Retornar la página de libros
    Pageable pageable = PageRequest.of(page, size);
    return new PageImpl<>(libroDTOs, pageable, total);
  }
  private long getTotalCount(CriteriaBuilder cb) {
    CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
    countQuery.select(cb.count(countQuery.from(Libro.class)));
    return entityManager.createQuery(countQuery).getSingleResult();
  }

}
