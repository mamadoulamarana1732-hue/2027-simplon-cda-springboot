package fr.simplon.domedespuys.entities;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.ProductView;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ProductView.Id.class)
    private Long id;

    @Column(nullable = false, length = 255)
    @JsonView(ProductView.Label.class)
    private String label;

    @Column(columnDefinition = "TEXT", nullable = false)
    @JsonView(ProductView.Description.class)
    private String description;

    @Column(nullable = false)
    @JsonView(ProductView.Price.class)
    private Float price;

    @Column(nullable = false, unique = true, length = 200)
    @JsonView(ProductView.Slug.class)
    private String slug;

    @Column(nullable = false, updatable = false)
    @JsonView(ProductView.CreatedAt.class)
    private LocalDateTime createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonView(ProductView.Brand.class)
    private Brand brand;

    @OneToMany(mappedBy = "product")
    @JsonView(ProductView.Images.class)
    private List<Image> images = new ArrayList<>();

    public void addImage(Image image) {
        images.add(image);
        image.setProduct(this);
    }

    @JsonView(ProductView.MainImage.class)
    public Image getMainImage() {
        for (Image image : images) {
            if (image.isDefault()) {
                return image;
            }
        }
        return null;
    }



}
