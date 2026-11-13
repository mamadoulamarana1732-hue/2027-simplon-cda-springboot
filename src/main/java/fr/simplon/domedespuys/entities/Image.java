package fr.simplon.domedespuys.entities;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.ImageView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ImageView.Id.class)
    private Long id;

    @Column(nullable = false, length = 255)
    @JsonView(ImageView.Path.class)
    private String path;

    @Column(nullable = false)
    @JsonView(ImageView.Extension.class)
    private String extension;

    @Column(name = "is_default", nullable = false)
    @JsonView(ImageView.IsDefault.class)
    private boolean isDefault;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Product product;

    public void setUrl(String url) {

    }
}
