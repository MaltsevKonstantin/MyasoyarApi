package ru.maltsevkonstantin.myasoyarapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltsevkonstantin.myasoyarapi.models.security.User;

import java.util.Optional;

public interface UsersAuthorityRepo extends JpaRepository<User.Authority, Integer> {
    void deleteByUser(User user);
}
