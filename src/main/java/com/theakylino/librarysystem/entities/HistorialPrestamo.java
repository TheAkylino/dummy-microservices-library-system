package com.theakylino.librarysystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "historial_prestamo")
public class HistorialPrestamo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "fecha_prestamo", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaPrestamo;

  @Column(name = "fecha_devolucion")
  @Temporal(TemporalType.DATE)
  private Date fechaDevolucion;

  @Column(nullable = false)
  private String estado; // Completo / Incompleto

  // Relación muchos a uno con Libro
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "libro_id")
  private Libro libro;
}
