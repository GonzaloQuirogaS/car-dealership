package com.app.cardealership.services;

import com.app.cardealership.dto.CarDto;
import com.app.cardealership.persistance.entities.Car;

import java.util.List;

public interface ICarService {

    List<CarDto> findAll();

    CarDto saveDto(CarDto carDto);
    Car save(Car car);

    void deleteById(Long id);

    CarDto findByIdDto(Long id);

    Car findById(Long id);

}
