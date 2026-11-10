package fr.simplon.domedespuys.dto;

import lombok.Data;

import java.util.List;
@Data
public class ProductPutDTO {
    private String label;
    private String description;
    private Float price;
    private String brand;
    private List<String> images;
}
