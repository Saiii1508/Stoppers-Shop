package com.stopperstop.entities;

import com.stopperstop.entities.enums.OrderStatus;
import com.stopperstop.entities.enums.PaymentMethod;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String orderNumber; // "ORD-20230515-0001"

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    @ManyToOne(fetch = FetchType.LAZY)
    private Address shippingAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    private Address billingAddress;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private BigDecimal totalAmount;

    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
}