package com.app.cardealership.dto;

import com.app.cardealership.persistance.entities.Car;
import com.app.cardealership.persistance.entities.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
