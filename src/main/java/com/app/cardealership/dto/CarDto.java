package com.app.cardealership.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

//DTO de la clase Car que devuelve todos los atributos de la clase Car
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto implements Serializable {

    private Long id;
    private String brand;
    private Double km;
    private String color;
    private String img;
    private LocalDate date;
    private String description;
    private LocalDateTime savedAt = LocalDateTime.now();
    private Long price;
    private String car_condition;

}
