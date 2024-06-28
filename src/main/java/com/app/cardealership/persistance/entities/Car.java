package com.app.cardealership.persistance.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private Double km;
    private String color;
    private LocalDateTime savedAt = LocalDateTime.now();
    private String img;
    private LocalDate date;
    private String description;
    private Long price;
    private String car_condition;

}
