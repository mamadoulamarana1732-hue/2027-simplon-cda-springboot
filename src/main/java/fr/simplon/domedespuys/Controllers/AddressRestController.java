package fr.simplon.domedespuys.Controllers;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.entities.Address;
import fr.simplon.domedespuys.service.interfaces.IAddressService;
import fr.simplon.domedespuys.view.AddressView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
public class AddressRestController {
    private final IAddressService addressService;
    @PostMapping
    @JsonView(AddressView.AddressDetailView.class)
    public Address createAddress(@RequestBody AddressDTO dto) {
        return addressService.create(dto);
    }
}
