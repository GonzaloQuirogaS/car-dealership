package com.app.cardealership.persistance.repository;

import com.app.cardealership.persistance.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
