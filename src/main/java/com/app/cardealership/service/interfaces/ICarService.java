package com.app.cardealership.service.interfaces;

import com.app.cardealership.presentation.dto.car.CarDto;
import com.app.cardealership.presentation.dto.car.SaveCarDto;
import com.app.cardealership.persistence.entity.Car;

import java.util.List;

public interface ICarService {

    List<CarDto> findAll();

    CarDto saveDto(SaveCarDto saveCarDto);
    Car save(Car car);

    void deleteById(Long id);

    CarDto findByIdDto(Long id);

    Car findById(Long id);

}
