package com.g2m.razorpayservice.service;

import com.g2m.razorpayservice.model.Orders;
import com.g2m.razorpayservice.repository.OrderRepository;
import org.springframework.stereotype.Service;


import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import jakarta.annotation.PostConstruct;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderRepository ordersRepository;

    @Value("${razorpay.key.id}")
    private String razorpayId;
    @Value("${razorpay.key.secret}")
    private String razorpaySecret;

    private RazorpayClient razorpayCLient;

    @PostConstruct
    public void init() throws RazorpayException {
        this.razorpayCLient = new RazorpayClient(razorpayId, razorpaySecret);
    }

    public Orders createOrder(Orders order) throws RazorpayException {
        JSONObject options = new JSONObject();
        options.put("amount", order.getAmount() * 100); // amount in paise
        options.put("currency", "INR");
        options.put("receipt", order.getEmail());
//        options.put("product",order.getProductName());
        Order razorpayOrder = razorpayCLient.orders.create(options);
        if(razorpayOrder != null) {
            order.setRazorpayOrderId(razorpayOrder.get("id"));
            order.setOrderStatus(razorpayOrder.get("status"));
        }
        return ordersRepository.save(order);
    }

    public Orders updateStatus(Map<String, String> map) {
        String razorpayId = map.get("razorpay_order_id");
        Orders order = ordersRepository.findByRazorpayOrderId(razorpayId);
        order.setOrderStatus("PAYMENT DONE");
        Orders orders = ordersRepository.save(order);
        return orders;
    }
}
