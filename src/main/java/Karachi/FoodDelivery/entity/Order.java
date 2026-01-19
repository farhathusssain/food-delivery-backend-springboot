package Karachi.FoodDelivery.entity;

import Karachi.FoodDelivery.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userEmail;
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private LocalDateTime createdAt;

}
