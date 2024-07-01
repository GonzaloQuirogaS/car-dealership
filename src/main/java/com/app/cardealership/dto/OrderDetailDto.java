package com.app.cardealership.dto;

import com.app.cardealership.persistance.entities.Car;
import com.app.cardealership.persistance.entities.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//DTO de la clase OrderDetail que devuelve todos los atributos de la clase OrderDetail
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto implements Serializable {

    private Long id;
    private String user_name;
    private String user_surname;
    private Double price;
    private String email;
    private Long phone;
    private Double total_price;
    private Car car;
    @JsonIgnore
    private Order order;
}
