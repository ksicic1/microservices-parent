package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItems;
import com.example.orderservice.model.dao.OrderRepository;
import com.example.orderservice.model.dto.OrderLineItemsDto;
import com.example.orderservice.model.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDtoList().stream().map(this::mapTo).toList();
        order.setOrderLineItemsList(orderLineItemsList);

        orderRepository.save(order);
    }

    public List<Order> fetchOrders() {
        return orderRepository.findAll();
    }

    private OrderLineItems mapTo(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());

        return orderLineItems;
    }
}
