package com.g2m.razorpayservice.controller;

import com.g2m.razorpayservice.model.Orders;
import com.g2m.razorpayservice.service.OrderService;
import com.razorpay.RazorpayException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@CrossOrigin("*")
@RequiredArgsConstructor
public class OrdersController {
    private final OrderService orderService;
    @GetMapping("/Welcome")
    public void welcomePage(){

    }
    @GetMapping("/Orders")
    public String ordersPage(){
        return "orders";
    }

    @PostMapping(value = "/createOrder", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Orders> createOrder(@RequestBody Orders orders) throws RazorpayException {
       System.out.println(orders);
        Orders razorpayOrder = orderService.createOrder(orders);
        return new ResponseEntity<>(razorpayOrder, HttpStatus.CREATED);
    }

    @PostMapping("/paymentCallback")
    public String paymentCallback(@RequestParam Map<String, String> response) {
        orderService.updateStatus(response);
        return "success";

    }
}
