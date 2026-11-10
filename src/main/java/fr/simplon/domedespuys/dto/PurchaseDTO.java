package fr.simplon.domedespuys.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PurchaseDTO {
    private List<String> address;
    private List<String> purchaseProducts;
    private Date createdAt;
    private List<String> status;
}
