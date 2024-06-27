package com.app.cardealership.mapper;

import com.app.cardealership.dto.CarDto;
import com.app.cardealership.persistance.entities.Car;
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
        carDto.setCar_condition(car.getCar_condition());
        carDto.setPrice(car.getPrice());
        carDto.setDate(car.getDate());
        carDto.setDescription(car.getDescription());
        return carDto;
    }
}
