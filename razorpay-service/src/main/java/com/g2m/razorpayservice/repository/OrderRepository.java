package com.g2m.razorpayservice.repository;

import com.g2m.razorpayservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
    Orders findByRazorpayOrderId(String razorpayId);
}
