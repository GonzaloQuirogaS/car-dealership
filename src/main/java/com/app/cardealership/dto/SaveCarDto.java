package com.app.cardealership.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

//DTO de la clase Car que devuelve unicamente los valores necesarios para guardar un Car nuevo
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCarDto implements Serializable {

    @NotBlank
    private String brand;
    @NotNull
    private Double km;
    @NotBlank
    private String color;
    @NotBlank
    private String img;
    private LocalDate date;
    @NotBlank
    private String description;
    @NotNull
    private Long price;
    @NotBlank
    private String car_condition;

}
