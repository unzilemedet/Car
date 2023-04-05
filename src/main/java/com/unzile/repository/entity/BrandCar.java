package com.unzile.repository.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tblbrandcar")
public class BrandCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    Long carid;
    Long brandid;

}
