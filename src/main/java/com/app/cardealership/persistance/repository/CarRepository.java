package com.app.cardealership.persistance.repository;

import com.app.cardealership.persistance.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
