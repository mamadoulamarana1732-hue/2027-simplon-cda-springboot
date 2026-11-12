package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.BrandDTO;
import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;
import fr.simplon.domedespuys.entities.Brand;
import fr.simplon.domedespuys.entities.User;
import fr.simplon.domedespuys.repositories.UserRepository;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    @Override
    public User getById(String id) {
        return userRepository.findById(Long.parseLong(id)).orElse(null);
    }
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
    public User update(String id, UserPutDTO dto) {
        User user = getById(id);
        if (user != null){
            user.setLastname(dto.lastname);
            user.setFirstname(dto.firstname);
            user.setPassword(dto.phone);
        }
        return user;
    }

    @Override
    public User update(String id, UserPostDTO dto) {
        return null;
    }
}
