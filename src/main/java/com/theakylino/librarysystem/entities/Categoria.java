package com.theakylino.librarysystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "categoria")
@SequenceGenerator(name = "global_seq", sequenceName = "global_sequence", initialValue = 1000, allocationSize = 1)
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
  private Long id;

  @Column(nullable = false)
  private String nombre;

  @Column
  private String descripcion;

  // Relación muchos a muchos con Libro
  @ManyToMany(mappedBy = "categorias")
  private Set<Libro> libros = new HashSet<>();
}
