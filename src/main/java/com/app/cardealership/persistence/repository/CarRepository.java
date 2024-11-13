package com.app.cardealership.persistence.repository;

import com.app.cardealership.persistence.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
