package com.app.cardealership.services.impl;

import com.app.cardealership.dto.OrderDto;
import com.app.cardealership.mapper.Mapper;
import com.app.cardealership.persistance.entities.Order;
import com.app.cardealership.persistance.repository.OrderRepository;
import com.app.cardealership.services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;
    private final Mapper mapper;

    @Override
    public List<OrderDto> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(mapper::mapToOrderDto).collect(Collectors.toList());
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    @Override
    public OrderDto findByIdDto(Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        return mapper.mapToOrderDto(order);
    }
}
