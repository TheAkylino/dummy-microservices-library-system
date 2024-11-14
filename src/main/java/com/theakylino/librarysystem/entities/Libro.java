package com.theakylino.librarysystem.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "libro")
public class Libro {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String titulo;

  @Column(nullable = false, unique = true)
  private String isbn;

  @Column(name = "fecha_publicacion")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate fechaPublicacion;

  @Column(name = "estado")
  private String estado;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "autor_id")
  private Autor autor;

  @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Prestamo> prestamos = new HashSet<>();
}
