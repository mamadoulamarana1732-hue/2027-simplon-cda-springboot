package fr.simplon.domedespuys.entities;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.BrandView;
import fr.simplon.domedespuys.view.ProductView;
import fr.simplon.domedespuys.view.PurchaseView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(PurchaseView.Id.class)
    private Long id;

    @Column(length = 20, unique = true, nullable = false)
    @JsonView(PurchaseView.Number.class)
    private String number;

    @Column(nullable = false)
    @JsonView(PurchaseView.CreatedAt.class)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String status = EnumPurchaseStatus.PENDING.getValue();

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Address address;

    @OneToMany(mappedBy = "purchase")
    @JsonView(PurchaseView.PurchaseProducts.class)
    List<PurchaseProduct> purchaseProducts = new ArrayList<>();

}
