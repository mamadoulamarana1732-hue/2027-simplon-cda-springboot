package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class AddressDTO {
    @NotBlank(message = "Le line doit être renseigné")
    @Length(max = 200, message = "Le line ne doit pas dépasser 200")
    public String line;
    public String extraLine;
    @NotBlank(message = "Le Code postal doit être renseigné")
    @Length(max = 200, message = "Le Code Postal ne doit pas depasser 200")
    public String zipCode;
    @NotBlank(message = "La ville doit être renseigné")
    @Length(max = 200, message = "La ville ne doit pas depasser 200")
    public String city;
    @NotBlank(message = "Le Pays doit être renseigné")
    @Length(max = 200, message = "Le pays ne doit pas depasser 200")
    public String country;
    public String phone;
    @NotBlank(message = "Le prenom doit être renseigné")
    @Length(max = 200, message = "Le prenom ne doit pas depasser 200")
    public String firstName;
    @NotBlank(message = "Le nom doit être renseigné")
    @Length(max = 200, message = "Le nom ne doit pas depasser 200")
    public String lastName;
}