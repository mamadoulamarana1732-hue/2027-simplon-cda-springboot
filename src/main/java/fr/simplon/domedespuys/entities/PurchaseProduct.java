package fr.simplon.domedespuys.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PurchaseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Float price;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Purchase purchase;
}
