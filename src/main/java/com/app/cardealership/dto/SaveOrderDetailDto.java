package com.app.cardealership.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//DTO de la clase OrderDetail que devuelve unicamente los valores necesarios para guardar un OrderDetail nuevo
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveOrderDetailDto implements Serializable {

    @NotBlank
    private String user_name;
    @NotBlank
    private String user_surname;
    @NotBlank
    private String email;
    @NotNull
    @Min(1)
    private Long phone;

}
