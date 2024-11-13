package com.theakylino.librarysystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "categoria")
public class Categoria {
  @Id
  @Column(columnDefinition = "VARCHAR(36)")
  private UUID id;

  @Column(nullable = false)
  private String nombre;

  @Column
  private String descripcion;

  // Relación muchos a muchos con Libro
  @ManyToMany(mappedBy = "categorias")
  private Set<Libro> libros = new HashSet<>();

  @PrePersist
  public void generarUUID() {
    if (id == null) {
      id = UUID.randomUUID();
    }
  }
}
