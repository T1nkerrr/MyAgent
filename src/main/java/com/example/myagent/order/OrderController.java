package com.example.myagent.order;

import com.example.myagent.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @PostMapping("/create")
    public ResponseResult<Order> createOrder(
            @RequestParam String name,
            @RequestParam String realPrice,
            @RequestParam String delivery,
            @RequestParam String email,
            @RequestParam String payMethod
    ){
        Order order = new Order();
        order.setName(name);
        order.setRealPrice(realPrice);
        order.setDelivery(delivery);
        order.setEmail(email);
        order.setPayMethod(payMethod);

        order.setCreateTime(new Date().toString());
        order.setStatus(OrderStatus.UNPAID);
        order.setId(UUID.randomUUID().toString());

        orderService.createOrder(order);

        return ResponseResult.success(order);
    }
}
