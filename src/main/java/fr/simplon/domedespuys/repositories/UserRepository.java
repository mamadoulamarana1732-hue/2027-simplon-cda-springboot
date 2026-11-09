package fr.simplon.domedespuys.repositories;

import fr.simplon.domedespuys.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByFirstname(String firstname);

    Optional<User> findByEmail(String email);
}
