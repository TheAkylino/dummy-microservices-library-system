package com.theakylino.librarysystem.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "editorial")
public class Editorial {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nombre;

  @Column
  private String direccion;

  @Column
  private String telefono;

  // Relación uno a muchos con Libro
  @OneToMany(mappedBy = "editorial", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Libro> libros = new HashSet<>();
}
