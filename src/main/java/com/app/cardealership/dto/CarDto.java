package com.app.cardealership.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
