package com.app.cardealership.controllers;

import com.app.cardealership.dto.CarDto;
import com.app.cardealership.dto.SaveCarDto;
import com.app.cardealership.persistance.entities.Car;
import com.app.cardealership.services.ICarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
public class CarController {

    private final ICarService carService;

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @GetMapping
    @Tag(name = "GET", description = "GET methods")
    @Operation(summary = "Get all cars")
    private ResponseEntity<List<CarDto>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(carService.findAll());
    }

    @PostMapping("/save")
    @Tag(name = "POST", description = "POST methods")
    @Operation(summary = "Create a car")
    private ResponseEntity<?> save(@Valid @RequestBody SaveCarDto saveCarDto, BindingResult result) {
        try {
            if (result.hasFieldErrors()) {
                return validation(result);
            }
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
    @Operation(summary = "Delete a car")
    private ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            carService.deleteById(id);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("No fue posible eliminar auto, verifique el ID ingresado");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Eliminado con exito!");
    }

    @GetMapping("/{id}")
    @Tag(name = "GET", description = "GET methods")
    @Operation(summary = "Find car by ID")
    private ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Car car = carService.findById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(car);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("No existe auto con ese ID");
        }
    }

    @PutMapping("/update/{id}")
    @Tag(name = "UPDATE", description = "UPDATE methods")
    @Operation(summary = "Update car by ID")
    private ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody SaveCarDto saveCarDto, BindingResult result) {
        try {
            if (result.hasFieldErrors()) {
                return validation(result);
            }
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
                    .body("Error al actualizar el auto, verifique sus datos");
        }
    }

}
