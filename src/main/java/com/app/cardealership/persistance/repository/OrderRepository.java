package com.app.cardealership.persistance.repository;

import com.app.cardealership.persistance.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
