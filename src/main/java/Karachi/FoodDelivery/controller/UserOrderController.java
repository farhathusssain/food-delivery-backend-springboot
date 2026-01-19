package Karachi.FoodDelivery.controller;

import Karachi.FoodDelivery.dto.PlaceOrderRequest;
import Karachi.FoodDelivery.entity.Order;
import Karachi.FoodDelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/orders")
public class UserOrderController {
    @Autowired
    private OrderService orderService;

    // PLACE order
    @PostMapping
    public Order placeOrder(@RequestBody PlaceOrderRequest request) {
        return orderService.placeOrder(request);
    }

    // VIEW own order
    @GetMapping
    public List<Order> getMyOrders(@RequestParam String email) {
        return orderService.getOrdersByUser(email);
    }
}
