package com.app.cardealership.controllers;

import com.app.cardealership.dto.OrderDetailDto;
import com.app.cardealership.services.IOrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order-detail")
@RequiredArgsConstructor
public class OrderDetailController {

    private final IOrderDetailService orderDetailService;

    @GetMapping()
    private ResponseEntity<List<OrderDetailDto>>findAll(){
        return ResponseEntity.ok(orderDetailService.findAll());
    }


}
