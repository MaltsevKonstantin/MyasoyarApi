package ru.maltsevkonstantin.myasoyarapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.maltsevkonstantin.myasoyarapi.models.security.User;
import ru.maltsevkonstantin.myasoyarapi.repos.UsersRepo;
import ru.maltsevkonstantin.myasoyarapi.security.MyasoyarUserDetails;

import java.util.Optional;

@Service
public class MyasoyarUserDetailsService implements UserDetailsService {

    UsersRepo repo;

    @Autowired
    public MyasoyarUserDetailsService(UsersRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optUser = repo.findByLogin(username);
        if (optUser.isEmpty()) throw new UsernameNotFoundException("Пользователь не найден.");
        return new MyasoyarUserDetails(optUser.get());
    }
}
