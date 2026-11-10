package fr.simplon.domedespuys.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    public String email;
    public String password;
    public String firstname;
    public String lastname;
    public String phone;
    public String  firstName;
    public String lastName;
    public Date createdAt;

}
