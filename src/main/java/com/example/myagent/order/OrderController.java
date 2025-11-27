package com.example.myagent.order;

import com.example.myagent.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/create")
    public ResponseResult<OrderInfo> createOrder(
            @RequestParam String name,
            @RequestParam String realPrice,
            @RequestParam String delivery,
            @RequestParam String email,
            @RequestParam String payMethod
    ){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setName(name);
        orderInfo.setRealPrice(realPrice);
        orderInfo.setDelivery(delivery);
        orderInfo.setEmail(email);
        orderInfo.setPayMethod(payMethod);

        orderInfo.setCreateTime(new Date().toString());
        orderInfo.setStatus(OrderStatus.UNPAID);
        orderInfo.setId(UUID.randomUUID().toString());

        orderService.createOrder(orderInfo);

        redisTemplate.opsForValue().set(orderInfo.getId(), "1",10, TimeUnit.MINUTES);

        return ResponseResult.success(orderInfo);
    }

    //分页显示order查询结果
    @RequestMapping("/{pageNum}")//http://localhost:8080/order/0?pageNumber=2&pageSize=10
    public ResponseResult<Iterable<OrderInfo>> getOrders(@PathVariable int pageNum, @RequestParam int pageSize){
        return ResponseResult.success(orderService.getOrders(PageRequest.of(pageNum, pageSize)).getContent());
    }

    @RequestMapping("/find")
    public ResponseResult<Page<OrderInfo>> findByEmail(
            @RequestParam String email,
            @RequestParam int pageNum,
            @RequestParam int pageSize){
        return ResponseResult.success(orderService.findByEmail(email, PageRequest.of(pageNum, pageSize)));
    }
}
