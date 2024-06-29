package com.app.cardealership.dto;

import com.app.cardealership.persistance.entities.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements Serializable {

    private Long id;
    private String order_number;
    private LocalDateTime created_at;
    private Double order_total;
    private List<OrderDetail> details;

}
