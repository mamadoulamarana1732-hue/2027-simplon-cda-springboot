package fr.simplon.domedespuys.entities;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.BrandView;
import fr.simplon.domedespuys.view.PurchaseProductView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PurchaseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(PurchaseProductView.Id.class)
    private Long id;

    @Column(length = 15, nullable = false)
    @JsonView(PurchaseProductView.Quantity.class)
    private Integer quantity;

    @Column(nullable = false)
    @JsonView(PurchaseProductView.Price.class)
    private Float price;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Purchase purchase;
}
