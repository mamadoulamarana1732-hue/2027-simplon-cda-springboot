package fr.simplon.domedespuys.dto;

import lombok.Data;

@Data
public class AddressDTO {
    public String line;
    public String extraLine;
    public String zipCode;
    public String city;
    public String country;
    public String phone;

}
