package com.g2m.razorpayservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "razorpay_order")
public class Orders {
    @Id
    @GeneratedValue
    private Integer orderId;
    private String name;
    private String email;
    private Integer amount;
    private String productName;
    private String orderStatus;
    private String razorpayOrderId;
}
