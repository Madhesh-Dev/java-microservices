package com.learn_java.order_service.service;

import com.learn_java.order_service.client.InventoryClient;
import com.learn_java.order_service.dto.OrderRequest;
import com.learn_java.order_service.model.Order;
import com.learn_java.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {
        boolean inStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if(inStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());

            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product with sku_code: " + orderRequest.skuCode() + " is not in stock");
        }
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
