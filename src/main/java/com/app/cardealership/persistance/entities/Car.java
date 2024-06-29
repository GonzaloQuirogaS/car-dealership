package com.app.cardealership.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank
    private String brand;
    @NotNull
    private Double km;
    @NotBlank
    private String color;
    private LocalDateTime savedAt = LocalDateTime.now();
    @NotBlank
    private String img;
    private LocalDate date;
    private String description;
    @NotNull
    private Long price;
    @NotBlank
    private String car_condition;

}
