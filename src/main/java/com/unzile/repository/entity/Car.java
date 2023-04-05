package com.unzile.repository.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblcar")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    @NotBlank
    String name;
    String model;
    Integer year;
    double dailyprice;
    String description;
}
