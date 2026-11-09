package fr.simplon.domedespuys.entities;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.PurchaseProductView;
import fr.simplon.domedespuys.view.UserView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(UserView.Id.class)
    private Long id;

    @OneToMany(mappedBy = "user")
    List<Purchase> purchases;

    @OneToMany(mappedBy = "user")
    List<Purchase> addresses;

    @Column(nullable = false, unique = true, length = 255)
    @JsonView(UserView.Email.class)
    private String email;

    @Column(nullable = false, length = 255)
    @JsonView(UserView.Password.class)
    private String password;

    @Column(nullable = false, length = 100)
    @JsonView(UserView.Firstname.class)
    private String firstname;

    @Column(nullable = false, length = 100)
    @JsonView(UserView.Lastname.class)
    private String lastname;

    @Column(length = 20)
    @JsonView(UserView.Phone.class)
    private String phone;

    @Column(nullable = false, updatable = false)
    @JsonView(UserView.CreatedAt.class)
    private LocalDateTime createdAt;

}
