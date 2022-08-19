package ru.maltsevkonstantin.myasoyarapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maltsevkonstantin.myasoyarapi.exceptions.UserWithThisLoginExistsException;
import ru.maltsevkonstantin.myasoyarapi.models.security.User;
import ru.maltsevkonstantin.myasoyarapi.models.security.UserAuthorities;
import ru.maltsevkonstantin.myasoyarapi.repos.UsersAuthorityRepo;
import ru.maltsevkonstantin.myasoyarapi.repos.UsersRepo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    UsersRepo repo;
    UsersAuthorityRepo authorityRepo;

    @Autowired
    public UsersService(UsersRepo repo, UsersAuthorityRepo authorityRepo) {
        this.repo = repo;
        this.authorityRepo = authorityRepo;
    }

    public List<User> findAll() {
        return repo.findAllOrderByName();
    }

    public Optional<User> findById(int id) {
        return repo.findById(id);
    }

    public Optional<User> findByLogin(String login) {
        return repo.findByLogin(login);
    }

    @Transactional
    public void save(User user) {
        Optional<User> optionalUser = repo.findByLogin(user.getLogin());
        if (optionalUser.isPresent()) {
            if (optionalUser.get().getId() != user.getId()) throw new UserWithThisLoginExistsException("Пользователь с таким логином уже существует");
            authorityRepo.deleteByUser(user);
        }
        user.setDateCreation(new Date());
        for (User.Authority authority: user.getAuthorities()) {
            authority.setUser(user);
        }
        repo.save(user);
    }
}
