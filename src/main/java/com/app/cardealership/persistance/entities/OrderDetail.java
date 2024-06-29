package com.app.cardealership.persistance.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    @Size(min = 2)
    private String user_name;
    @NotBlank
    @Size(min = 2)
    private String user_surname;
    private Double price;
    @NotBlank
    @Size(min = 2)
    private String email;
    @NotNull
    @Min(1)
    private Long phone;
    private Double total_price;

    @ManyToOne
    private Car car;

    @JsonIgnore
    @ManyToOne
    private Order order;
}
