package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.UserDTO;
import fr.simplon.domedespuys.entities.User;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    @Override
    public User create(UserDTO dto) {
        User user = new User();
        user.setLastname(dto.lastname);
        user.setFirstname(dto.firstname);
        user.setPassword(dto.password);
        return user;
    }
    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public User update(String id, UserDTO dto) {
        return null;
    }
}
