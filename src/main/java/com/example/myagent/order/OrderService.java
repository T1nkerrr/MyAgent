package com.example.myagent.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void createOrder(Order order) {
        orderRepository.save(order);
    }
}
