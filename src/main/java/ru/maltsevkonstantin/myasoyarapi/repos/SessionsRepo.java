package ru.maltsevkonstantin.myasoyarapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltsevkonstantin.myasoyarapi.models.security.Session;

import java.util.Date;
import java.util.Optional;

public interface SessionsRepo extends JpaRepository<Session, Integer> {
    Optional<Session> findByTokenAndLifeTimeGreaterThan(String token, Date date);
}
