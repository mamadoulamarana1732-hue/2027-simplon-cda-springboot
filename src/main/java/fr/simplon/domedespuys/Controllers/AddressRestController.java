package fr.simplon.domedespuys.Controllers;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.entities.Address;
import fr.simplon.domedespuys.service.interfaces.IAddressService;
import fr.simplon.domedespuys.view.AddressView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("/api/address")
@AllArgsConstructor
public class AddressRestController {

    private IAddressService addressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address addAddress(@Valid @RequestBody AddressDTO address) {
        return addressService.create(address);
    }

    @DeleteMapping("/{id}")
    @JsonView(AddressView.AddressDetailView.class)
    public boolean delete(@PathVariable String id) {
        return addressService.delete(id);
    }


}