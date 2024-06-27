package com.app.cardealership.services.impl;

import com.app.cardealership.dto.CarDto;
import com.app.cardealership.mapper.Mapper;
import com.app.cardealership.persistance.entities.Car;
import com.app.cardealership.persistance.repository.CarRepository;
import com.app.cardealership.services.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements ICarService {

    private final CarRepository carRepository;
    private final Mapper mapper;

    @Override
    public List<CarDto> findAll() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map((mapper::mapToCarDto)).collect(Collectors.toList());
    }

    @Override
    public CarDto saveDto(CarDto carDto) {
        Car car = new Car();
        car.setCar_condition(carDto.getCar_condition());
        car.setBrand(carDto.getBrand());
        car.setKm(carDto.getKm());
        car.setDate(carDto.getDate());
        car.setColor(carDto.getColor());
        car.setImg(carDto.getImg());
        car.setDescription(carDto.getDescription());
        car.setPrice(carDto.getPrice());
        carRepository.save(car);
        return mapper.mapToCarDto(car);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarDto findByIdDto(Long id) {
        Car car = carRepository.findById(id).orElseThrow();
        return mapper.mapToCarDto(car);
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow();
    }
}
