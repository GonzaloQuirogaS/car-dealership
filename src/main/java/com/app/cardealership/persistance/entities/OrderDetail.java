package com.app.cardealership.persistance.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user_name;
    private String user_surname;
    private Double price;
    private String email;
    private Long phone;
    private Double total_price;

    @ManyToOne
    private Car car;

    @JsonIgnore
    @ManyToOne
    private Order order;
}
