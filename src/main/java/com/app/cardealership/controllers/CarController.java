package com.app.cardealership.controllers;

import com.app.cardealership.dto.CarDto;
import com.app.cardealership.dto.SaveCarDto;
import com.app.cardealership.persistance.entities.Car;
import com.app.cardealership.services.ICarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
public class CarController {

    private final ICarService carService;

    @GetMapping
    @Tag(name = "GET", description = "GET methods")
    private ResponseEntity<List<CarDto>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(carService.findAll());
    }

    @PostMapping("/save")
    @Tag(name = "SAVE", description = "SAVE methods")
    private ResponseEntity<?> save(SaveCarDto saveCarDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(carService.saveDto(saveCarDto));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error al guardar");
        }
    }

    @DeleteMapping("/delete/{id}")
    @Tag(name = "DELETE", description = "DELETE methods")
    private ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            carService.deleteById(id);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("No fue posible eliminar auto");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Eliminado con exito!");
    }

    @GetMapping("/{id}")
    @Tag(name = "GET", description = "GET methods")
    private ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Car car = carService.findById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(car);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error al ingresar el id");
        }
    }

    @PutMapping("/update/{id}")
    @Tag(name = "UPDATE", description = "UPDATE methods")
    private ResponseEntity<?> update(@PathVariable Long id, @RequestBody SaveCarDto saveCarDto) {
        try {
            Car car = carService.findById(id);
            car.setDescription(saveCarDto.getDescription());
            car.setDate(saveCarDto.getDate());
            car.setKm(saveCarDto.getKm());
            car.setImg(saveCarDto.getImg());
            car.setPrice(saveCarDto.getPrice());
            car.setColor(saveCarDto.getColor());
            car.setBrand(saveCarDto.getBrand());
            car.setCar_condition(saveCarDto.getCar_condition());

            carService.save(car);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(car);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error al actualizar el auto");
        }
    }

}
