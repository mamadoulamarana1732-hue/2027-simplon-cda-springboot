package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.entities.Image;
import lombok.Data;

import java.util.List;
@Data
public class ProductPostDTO {
    private String label;
    private String description;
    private Float price;
    private String brand;
    private List<String> images;

}
