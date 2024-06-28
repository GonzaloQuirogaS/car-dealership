package com.app.cardealership.services;

import com.app.cardealership.dto.OrderDto;
import com.app.cardealership.persistance.entities.Order;

import java.util.List;

public interface IOrderService {

    List<OrderDto> findAll();

    Order save(Order order);

}
