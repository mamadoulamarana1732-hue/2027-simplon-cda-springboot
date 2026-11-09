package fr.simplon.domedespuys.entities;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.AddressView;
import fr.simplon.domedespuys.view.BrandView;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(AddressView.Id.class)
    private Long id;

    @Column(nullable = false, length = 200)
    @JsonView(AddressView.Line.class)
    private String line;

    @Column(nullable = true, length = 200)
    @JsonView(AddressView.Extraline.class)
    private String extraLine;

    @Column(nullable = false, length = 100)
    @JsonView(AddressView.City.class)
    private String city;

    @Column(nullable = false, length = 100)
    @JsonView(AddressView.ZipCode.class)
    private String zipCode;

    @Column(nullable = false, length = 100)
    @JsonView(AddressView.Country.class)
    private String country;

    @Column(nullable = false, length = 100)
    @JsonView(AddressView.Firstname.class)
    private String firstname;

    @Column(nullable = false, length = 100)
    @JsonView(AddressView.Lastname.class)
    private String lastname;

    @JsonView(AddressView.Phone.class)
    private String phone;

    @Column(nullable = false, updatable = false)
    @JsonView(AddressView.Created.class)
    private LocalDateTime createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User user;

}
