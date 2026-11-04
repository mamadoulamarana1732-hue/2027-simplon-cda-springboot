package fr.simplon.domedespuys.entities;

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
    private Long id;

    @Column(nullable = false, length = 255)
    private String path;

    @Column(nullable = false)
    private String extension;

    @Column(name = "is_default", nullable = false)
    private boolean isDefault;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Product product;

}
