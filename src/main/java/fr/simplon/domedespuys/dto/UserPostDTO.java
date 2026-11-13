package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class UserPostDTO {
    @NotBlank(message = "L'email doit être renseigné")
    @Length(max = 255, message = "L'email ne doit pas depasser 255")
    public String email;
    @Length(min = 8, max = 255, message = "Le mot de passe doit contenir entre 8 et 255 caractères")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).*$",
            message = "Le mot de passe doit contenir au moins une majuscule, une minuscule, un chiffre et un caractère spécial"
    )
    public String password;
    @NotBlank(message = "Le Prénom doit être renseigné")
    @Length(max = 100, message = "Le Prénom ne doit pas depasser 100")
    public String firstname;
    @NotBlank(message = "Le Nom doit être renseigné")
    @Length(max = 100, message = "Le Nom ne doit pas depasser 100")
    public String lastname;
}
