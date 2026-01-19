package Karachi.FoodDelivery.service;

import Karachi.FoodDelivery.dto.PlaceOrderRequest;
import Karachi.FoodDelivery.entity.Order;
import Karachi.FoodDelivery.enums.OrderStatus;
import Karachi.FoodDelivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

//    ADMIN
    public Order getOrderById(Long id) {
        return orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order cancelOrder(Long id) {
        Order order = getOrderById(id);

        if (order.getStatus() == OrderStatus.CANCELLED) {
            throw new RuntimeException("Order already cancelled");
        }

        order.setStatus(OrderStatus.CANCELLED);
        return orderRepo.save(order);
    }


    public Order placeOrder(PlaceOrderRequest request) {

        Order order = new Order();
        order.setUserEmail(request.getUserEmail());
        order.setTotalAmount(request.getTotalAmount());
        order.setStatus(OrderStatus.PLACED);
        order.setCreatedAt(LocalDateTime.now());

        return orderRepo.save(order);
    }


    public List<Order> getOrdersByUser(String userEmail) {
        return orderRepo.findByUserEmail(userEmail);
    }
}