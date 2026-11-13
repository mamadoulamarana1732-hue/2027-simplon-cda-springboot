package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.UserPostDTO;
import fr.simplon.domedespuys.dto.UserPutDTO;
import fr.simplon.domedespuys.entities.User;
import fr.simplon.domedespuys.repositories.UserRepository;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
        user.setEmail(dto.email);
        user.setLastname(dto.lastname);
        user.setFirstname(dto.firstname);
        user.setPassword(dto.password);
        //récupération de la date en temps reel
        LocalDateTime date = LocalDateTime.now();
        user.setCreatedAt(date);
        userRepository.saveAndFlush(user);
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
            user.setPhone(dto.phone);
            userRepository.saveAndFlush(user);
        }
        return user;
    }

    @Override
    public User update(String id, UserPostDTO dto) {
        return null;
    }
}
