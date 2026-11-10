package fr.simplon.domedespuys.dto;

import lombok.Data;

@Data
public class PurchaseProductDTO {
    private Integer quantity;
    private Float price;
    private Long idProduct;
}
