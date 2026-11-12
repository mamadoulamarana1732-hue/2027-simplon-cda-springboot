package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.entities.Address;
import fr.simplon.domedespuys.repositories.AddressRepository;
import fr.simplon.domedespuys.service.interfaces.IAddressService;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements IAddressService {
    private AddressRepository addressRepository;
    private final IUserService userService;
    @Override
    public Address create(AddressDTO dto) {
        Address address = new Address();
        address.setFirstname(dto.firstname);
        address.setLastname(dto.lastname);
        address.setCity(dto.city);
        address.setCountry(dto.country);
        address.setExtraLine(dto.extraLine);
        address.setLine(dto.line);
        address.setPhone(dto.phone);
        address.setZipCode(dto.zipCode);
        address.setCreatedAt(LocalDateTime.now());
        //address.setUser(userService.getById(String.valueOf(dto.userId)));
        addressRepository.saveAndFlush(address);
        addressRepository.flush();
        return address;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Address update(String id, AddressDTO dto) {
        return null;
    }
}
