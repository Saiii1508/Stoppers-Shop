package com.stopperstop.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "wishlists")
public class WishListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    private LocalDateTime addedAt = LocalDateTime.now();
    private String notes;
}