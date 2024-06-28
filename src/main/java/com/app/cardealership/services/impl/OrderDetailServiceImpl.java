package com.app.cardealership.services.impl;

import com.app.cardealership.dto.OrderDetailDto;
import com.app.cardealership.mapper.Mapper;
import com.app.cardealership.persistance.entities.OrderDetail;
import com.app.cardealership.persistance.repository.OrderDetailRepository;
import com.app.cardealership.services.IOrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements IOrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final Mapper mapper;

    @Override
    public List<OrderDetailDto> findAll() {
        List<OrderDetail> orderDetails = orderDetailRepository.findAll();
        return orderDetails.stream().map(mapper::mapToOrderDetailDto).collect(Collectors.toList());
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }
}
