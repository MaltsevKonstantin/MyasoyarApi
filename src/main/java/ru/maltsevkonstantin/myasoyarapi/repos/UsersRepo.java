package ru.maltsevkonstantin.myasoyarapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltsevkonstantin.myasoyarapi.models.security.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepo extends JpaRepository<User, Integer> {
    List<User> findAllByOrderByName();
    Optional<User> findByLogin(String login);
}
