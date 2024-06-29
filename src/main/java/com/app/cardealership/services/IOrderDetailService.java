package com.app.cardealership.services;

import com.app.cardealership.dto.OrderDetailDto;
import com.app.cardealership.persistance.entities.OrderDetail;

import java.util.List;

public interface IOrderDetailService {


    List<OrderDetailDto> findAll();
    OrderDetail save(OrderDetail orderDetail);


}
