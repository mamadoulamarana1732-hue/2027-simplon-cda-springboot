package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class UserPutDTO {
    @NotBlank(message = "Le Prénom doit être renseigné")
    @Length(max = 100, message = "Le Prénom ne doit pas depasser 100")
    public String firstname;
    @NotBlank(message = "Le Nom doit être renseigné")
    @Length(max = 100, message = "Le Nom ne doit pas depasser 100")
    public String lastname;
    @NotBlank(message = "Le Numéro de telephone doit être renseigné")
    @Length(max = 20, message = "Le Numéro de telephone ne doit pas depasser 20")
    public String phone;
}
