package com.example.orderservice.controller;


import com.example.orderservice.model.Order;
import com.example.orderservice.model.dto.OrderRequest;
import com.example.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/order")
@AllArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    private void placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
    }

    @GetMapping("/fetchOrders")
    @ResponseStatus(HttpStatus.OK)
    private List<Order> fetchOrders() {
        return orderService.fetchOrders();
    }

}
