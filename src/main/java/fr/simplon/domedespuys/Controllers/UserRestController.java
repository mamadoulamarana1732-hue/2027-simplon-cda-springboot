package fr.simplon.domedespuys.Controllers;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.entities.User;
import fr.simplon.domedespuys.repositories.UserRepository;
import fr.simplon.domedespuys.view.UserView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {
    private final UserRepository userRepository;

    @GetMapping()
    @JsonView(UserView.UserListView.class)
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{email}")
    @JsonView(UserView.UserListView.class)
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userRepository.findByEmail(String.valueOf(email));
    }

    @GetMapping("/{id}")
    @JsonView(UserView.UserDetailView.class)
    public Optional<User> getUserById(@PathVariable String id) {
        return userRepository.findById(Long.valueOf(id));
    }
}
