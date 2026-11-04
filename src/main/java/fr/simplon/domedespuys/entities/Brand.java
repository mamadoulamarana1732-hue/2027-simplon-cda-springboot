package fr.simplon.domedespuys.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 200)
    private String label;

    @Column(nullable = true, length = 200)
    private String logo;

    @Column(nullable = false, unique = true, length = 200)
    private String slug;

}
