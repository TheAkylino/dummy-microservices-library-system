package com.theakylino.librarysystem.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "prestamo")
public class Prestamo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "fecha_prestamo", nullable = false)
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate fechaPrestamo;

  @Column(name = "fecha_devolucion")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate fechaDevolucion;

  private String estado; // Activo / Finalizado

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "libro_id")
  private Libro libro;
}
