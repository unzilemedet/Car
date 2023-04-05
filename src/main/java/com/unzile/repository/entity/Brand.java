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
@Table(name = "tblbrand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    @NotBlank
    String name;
}
