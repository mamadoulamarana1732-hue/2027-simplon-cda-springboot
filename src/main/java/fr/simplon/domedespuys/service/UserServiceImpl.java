package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;
import fr.simplon.domedespuys.entities.User;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    @Override
    public User create(UserPostDTO dto) {
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
    public User update(String id, UserPostDTO dto) {
        return null;
    }

    @Override
    public User update(String id, UserPutDTO dto) {
        return null;
    }
}
