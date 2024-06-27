package com.app.cardealership.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCarDto implements Serializable {

    private String brand;
    private Double km;
    private String color;
    private String img;
    private LocalDate date;
    private String description;
    private Long price;
    private String car_condition;

}
