package Karachi.FoodDelivery.controller;

import Karachi.FoodDelivery.entity.Order;
import Karachi.FoodDelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/orders")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}/cancel")
    public Order cancelOrder(@PathVariable Long id) {
        return orderService.cancelOrder(id);
    }
}
