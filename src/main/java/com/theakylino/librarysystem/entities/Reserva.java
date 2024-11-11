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


@Entity
@Table(name = "reserva")
public class Reserva {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "fecha_reserva", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaReserva;

  @Column(nullable = false)
  private String estado; // Activa / Cancelada

  // Relación muchos a uno con Usuario
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "usuario_id")
  private Usuario usuario;

  // Relación muchos a uno con Libro
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "libro_id")
  private Libro libro;
}
