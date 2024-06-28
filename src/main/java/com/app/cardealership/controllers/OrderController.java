package com.app.cardealership.controllers;

import com.app.cardealership.dto.OrderDto;
import com.app.cardealership.dto.SaveOrderDetailDto;
import com.app.cardealership.persistance.entities.Car;
import com.app.cardealership.persistance.entities.Order;
import com.app.cardealership.persistance.entities.OrderDetail;
import com.app.cardealership.services.ICarService;
import com.app.cardealership.services.IOrderDetailService;
import com.app.cardealership.services.IOrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final ICarService carService;

    private final IOrderService orderService;

    private final IOrderDetailService orderDetailService;

    List<OrderDetail> details = new ArrayList<OrderDetail>();

    Order order = new Order();

    @GetMapping
    @Tag(name = "GET")
    private ResponseEntity<List<OrderDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAll());
    }

    //Carrito
    @PostMapping("/cart")
    private ResponseEntity<Car> addCart(@RequestParam Long id) {
        OrderDetail orderDetail = new OrderDetail();
        double sumaTotal = 0;
        Car car = carService.findById(id);
        orderDetail.setCar(car);
        orderDetail.setPrice(Double.valueOf(car.getPrice()));
        orderDetail.setTotal_price(Double.valueOf(car.getPrice()));

        details.add(orderDetail);

        sumaTotal = details.stream().mapToDouble(OrderDetail::getTotal_price).sum();

        order.setOrder_total(sumaTotal);
        return ResponseEntity.status(HttpStatus.OK).body(orderDetail.getCar());
    }

    @GetMapping("/cart")
    private ResponseEntity<Stream<Car>> getCart() {
        return ResponseEntity.ok(details.stream().map(OrderDetail::getCar));
    }


    @PostMapping("/save")
    private ResponseEntity<?> save(@RequestBody SaveOrderDetailDto orderDetail) {
        String number = UUID.randomUUID().toString();
        order.setOrder_number(number);
        orderService.save(order);
        for (OrderDetail dt : details) {
            dt.setEmail(orderDetail.getEmail());
            dt.setPhone(orderDetail.getPhone());
            dt.setUser_name(orderDetail.getUser_name());
            dt.setUser_surname(orderDetail.getUser_surname());
            dt.setOrder(order);
            orderDetailService.save(dt);
        }
        List<OrderDetail> detail = details;
        order = new Order();
        details.clear();
        return ResponseEntity.ok(detail);
    }

}
