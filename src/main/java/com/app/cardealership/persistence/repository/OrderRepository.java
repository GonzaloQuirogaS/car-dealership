package com.app.cardealership.persistence.repository;

import com.app.cardealership.persistence.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
