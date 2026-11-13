package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class ProductDTO {
    @NotBlank(message = "Le label doit être renseigné")
    @Length(max = 255, message = "Le label ne doit pas depasser 200")
    public String label;
    public String description;
    @DecimalMin(value = "0.50", message = "Le prix doit être supérieur ou égal à 0.50")
    public Float price;
    public Long brandId;
    public List<ImageDTO> images;
}
