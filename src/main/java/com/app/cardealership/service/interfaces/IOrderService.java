package com.app.cardealership.service.interfaces;

import com.app.cardealership.presentation.dto.order.OrderDto;
import com.app.cardealership.persistence.entity.Order;

import java.util.List;

public interface IOrderService {

    List<OrderDto> findAll();

    Order save(Order order);
    Order findById(Long id);

    OrderDto findByIdDto(Long id);

}
