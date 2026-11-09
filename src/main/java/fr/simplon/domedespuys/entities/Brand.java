package fr.simplon.domedespuys.entities;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.BrandView;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(BrandView.Id.class)
    private Long id;

    @Column(nullable = false, unique = true, length = 200)
    @JsonView(BrandView.Label.class)
    private String label;

    @Column(nullable = true, length = 200)
    @JsonView(BrandView.Logo.class)
    private String logo;

    @Column(nullable = false, unique = true, length = 200)
    @JsonView(BrandView.Slug.class)
    private String slug;

    @OneToMany(mappedBy = "brand")
    @JsonView(BrandView.Products.class)
    private List<Product> products = new ArrayList<>();

}
