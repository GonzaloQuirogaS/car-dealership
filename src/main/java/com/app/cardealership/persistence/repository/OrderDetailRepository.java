package com.app.cardealership.persistence.repository;

import com.app.cardealership.persistence.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
