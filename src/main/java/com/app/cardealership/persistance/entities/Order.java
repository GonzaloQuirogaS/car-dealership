package com.app.cardealership.persistance.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String order_number;
    private LocalDateTime created_at = LocalDateTime.now();
    private Double order_total;

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> details;

}
