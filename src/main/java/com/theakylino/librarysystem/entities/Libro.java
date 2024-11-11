package com.theakylino.librarysystem.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "libro")
public class Libro {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String titulo;

  @Column(nullable = false, unique = true)
  private String isbn;

  @Column(name = "fecha_publicacion")
  @Temporal(TemporalType.DATE)
  private Date fechaPublicacion;

  @Column(nullable = false)
  private String estado; // Disponible / No disponible

  // Relación muchos a uno con Editorial
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "editorial_id")
  private Editorial editorial;

  // Relación muchos a uno con Autor
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "autor_id")
  private Autor autor;

  // Relación muchos a muchos con Categoría
  @ManyToMany
  @JoinTable(
      name = "libro_categoria",
      joinColumns = @JoinColumn(name = "libro_id"),
      inverseJoinColumns = @JoinColumn(name = "categoria_id")
  )
  private Set<Categoria> categorias = new HashSet<>();

  // Relación uno a muchos con Préstamo
  @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Prestamo> prestamos = new HashSet<>();

  // Relación uno a muchos con Reserva
  @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Reserva> reservas = new HashSet<>();

  // Relación uno a muchos con Historial de Préstamo
  @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<HistorialPrestamo> historialPrestamos = new HashSet<>();
}
