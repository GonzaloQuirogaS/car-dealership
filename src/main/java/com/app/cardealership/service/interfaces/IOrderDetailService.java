package com.app.cardealership.service.interfaces;

import com.app.cardealership.presentation.dto.orderDetail.OrderDetailDto;
import com.app.cardealership.persistence.entity.OrderDetail;

import java.util.List;

public interface IOrderDetailService {


    List<OrderDetailDto> findAll();
    OrderDetail save(OrderDetail orderDetail);


}
