package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.entities.Image;

import java.util.List;

public class ProductPostDTO {
    private String label;
    private String description;
    private Float price;
    private String brand;
    private List<imageDTO> images;
    public class imageDTO {
        public String Path;
        public boolean is_default;
    }
}
