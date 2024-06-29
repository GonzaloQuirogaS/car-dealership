package com.app.cardealership.mapper;

import com.app.cardealership.dto.CarDto;
import com.app.cardealership.dto.OrderDetailDto;
import com.app.cardealership.dto.OrderDto;
import com.app.cardealership.persistance.entities.Car;
import com.app.cardealership.persistance.entities.Order;
import com.app.cardealership.persistance.entities.OrderDetail;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public CarDto mapToCarDto(Car car) {
        if (car == null) return null;

        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setBrand(car.getBrand());
        carDto.setKm(car.getKm());
        carDto.setColor(car.getColor());
        carDto.setImg(car.getImg());
        carDto.setSavedAt(car.getSavedAt());
        carDto.setCar_condition(car.getCar_condition());
        carDto.setPrice(car.getPrice());
        carDto.setDate(car.getDate());
        carDto.setDescription(car.getDescription());
        return carDto;
    }

    public OrderDto mapToOrderDto(Order order) {
        if (order == null) return null;
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setOrder_number(order.getOrder_number());
        orderDto.setOrder_total(order.getOrder_total());
        orderDto.setCreated_at(order.getCreated_at());
        orderDto.setDetails(order.getDetails());
        return orderDto;
    }

    public OrderDetailDto mapToOrderDetailDto(OrderDetail orderDetail){
        if (orderDetail == null) return null;
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setOrder(orderDetail.getOrder());
        orderDetailDto.setId(orderDetail.getId());
        orderDetailDto.setPrice(orderDetail.getPrice());
        orderDetailDto.setCar(orderDetail.getCar());
        orderDetailDto.setPhone(orderDetail.getPhone());
        orderDetailDto.setEmail(orderDetail.getEmail());
        orderDetailDto.setUser_name(orderDetail.getUser_name());
        orderDetailDto.setUser_surname(orderDetail.getUser_surname());
        orderDetailDto.setTotal_price(orderDetail.getTotal_price());
        return orderDetailDto;
    }
}
