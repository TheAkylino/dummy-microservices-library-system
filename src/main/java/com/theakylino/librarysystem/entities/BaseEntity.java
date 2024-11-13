package com.theakylino.librarysystem.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

@Setter
@Getter
@MappedSuperclass
@SequenceGenerator(name = "global_seq", sequenceName = "global_sequence", initialValue = 100, allocationSize = 1)
public abstract class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
  private Long id;
}
