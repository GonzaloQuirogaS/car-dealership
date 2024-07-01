package com.app.cardealership.controllers;

import com.app.cardealership.dto.OrderDto;
import com.app.cardealership.dto.SaveOrderDetailDto;
import com.app.cardealership.persistance.entities.Car;
import com.app.cardealership.persistance.entities.Order;
import com.app.cardealership.persistance.entities.OrderDetail;
import com.app.cardealership.services.ICarService;
import com.app.cardealership.services.IOrderDetailService;
import com.app.cardealership.services.IOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final ICarService carService;

    private final IOrderService orderService;

    private final IOrderDetailService orderDetailService;

    //Inicializamos una lista de detalles vacia de forma global para realizar operaciones sobre ella
    List<OrderDetail> details = new ArrayList<>();

    //Creamos una orden vacia de forma global para para realizar operaciones sobre ella
    Order order = new Order();

    //Metodo validation() que se encarga de validar los datos ingresados en el metodo save()
    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    //Metodo para ver todas las ordenes registradas en la base de dato
    @GetMapping
    @Tag(name = "GET")
    @Operation(summary = "Get all orders")
    private ResponseEntity<List<OrderDto>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.findAll());
    }

    //Cart
    //Metodo que agrega un auto al carrito recibiendo como parametro el id de un auto
    @PostMapping("/cart/{id}")
    @Tag(name = "POST")
    @Operation(summary = "Add car to cart by ID")
    private ResponseEntity<?> addCart(@PathVariable Long id) {
        try {
            OrderDetail orderDetail = new OrderDetail();
            double sumaTotal;
            Car car = carService.findById(id);
            orderDetail.setCar(car);
            orderDetail.setPrice(Double.valueOf(car.getPrice()));
            orderDetail.setTotal_price(Double.valueOf(car.getPrice()));

            details.add(orderDetail);

            sumaTotal = details.stream().mapToDouble(OrderDetail::getTotal_price).sum();

            order.setOrder_total(sumaTotal);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(details.stream().map(OrderDetail::getCar));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error, el ID no pertenece a ningun auto");
        }
    }

    //Metodo que elimina un auto al carrito recibiendo como parametro el id de un auto
    @DeleteMapping("/delete-cart/{id}")
    @Tag(name = "DELETE")
    @Operation(summary = "Delete car from cart by ID")
    private ResponseEntity<?> deleteCart(@PathVariable Long id) {
        try {
            List<OrderDetail> newOrders = new ArrayList<>();
            for (OrderDetail orderDetail : details) {

                if (!orderDetail.getCar().getId().equals(id)) {
                    newOrders.add(orderDetail);
                }
            }
            details = newOrders;
            double sumaTotal;
            sumaTotal = details.stream().mapToDouble(OrderDetail::getTotal_price).sum();

            order.setOrder_total(sumaTotal);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(details.stream().map(OrderDetail::getCar));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error, el id ingresado no corresponde a ningun auto");
        }
    }

    //Metodo que nos muestra todos los items guardados en el carrito
    @GetMapping("/cart")
    @Tag(name = "GET")
    @Operation(summary = "Get cart")
    private ResponseEntity<?> getCart() {
        try {
            if (!details.isEmpty()) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(details.stream().map(OrderDetail::getCar));
            }
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("No hay elementos en el cart");
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("No hay elementos en el cart");
    }

    //Metodo para guardar una orden recibiendo como body los datos del usuario efectuando la compra
    @PostMapping("/save")
    @Tag(name = "POST")
    @Operation(summary = "Create an order")
    private ResponseEntity<?> save(@Valid @RequestBody SaveOrderDetailDto orderDetail, BindingResult result) {
        try {
            if (result.hasFieldErrors()) {
                return validation(result);
            }
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
            Order order1 = order;
            order = new Order();
            details.clear();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(order1);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear la orden, verifique sus datos");
        }
    }

    //Metodo para obtener una orden mediante su ID
    @GetMapping("/{id}")
    @Tag(name = "GET")
    @Operation(summary = "Find order by ID")
    private ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            OrderDto orderDto = orderService.findByIdDto(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(orderDto);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("No existe orden con ese ID, verifique sus datos");
        }
    }

}
