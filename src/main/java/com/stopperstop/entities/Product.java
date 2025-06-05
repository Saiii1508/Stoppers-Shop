package com.stopperstop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Lob
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @ElementCollection
    private List<String> imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String brand;
    private String color;
    private String sizeOptions; // "S,M,L,XL"

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
