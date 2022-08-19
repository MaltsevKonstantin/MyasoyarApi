package ru.maltsevkonstantin.myasoyarapi.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maltsevkonstantin.myasoyarapi.dto.AuthenticationDto;
import ru.maltsevkonstantin.myasoyarapi.dto.UserDto;
import ru.maltsevkonstantin.myasoyarapi.exceptions.AuthenticationErrorException;
import ru.maltsevkonstantin.myasoyarapi.models.security.Session;
import ru.maltsevkonstantin.myasoyarapi.repos.SessionsRepo;
import ru.maltsevkonstantin.myasoyarapi.repos.UsersRepo;
import ru.maltsevkonstantin.myasoyarapi.security.MyasoyarUserDetails;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class SessionsService {
    private static final String AUTHENTICATION_ERROR_MESSAGE = "Ошибка авторизации.";
    private static final int SESSION_LIFE_TIME = 3;

    MyasoyarUserDetailsService userDetailsService;
    SessionsRepo sessionsRepo;

    ModelMapper modelMapper;

    @Autowired
    public SessionsService(MyasoyarUserDetailsService userDetailsService, SessionsRepo sessionsRepo, ModelMapper modelMapper) {
        this.userDetailsService = userDetailsService;
        this.sessionsRepo = sessionsRepo;
        this.modelMapper = modelMapper;
    }

    public UserDto createSession(AuthenticationDto authenticationDto) {
        try {
            MyasoyarUserDetails userDetails = (MyasoyarUserDetails) userDetailsService.loadUserByUsername(authenticationDto.getLogin());

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if (!encoder.matches(authenticationDto.getPassword(), userDetails.getPassword())) {
                throw new AuthenticationErrorException(AUTHENTICATION_ERROR_MESSAGE);
            }

            Session session = new Session();
            session.setUser(userDetails.getUser());
            Calendar calendar = Calendar.getInstance();
            session.setToken(encoder.encode(userDetails.getUsername() + calendar.getTimeInMillis()));
            session.setCreationDate(calendar.getTime());
            session.setLastActivityTime(calendar.getTime());
            calendar.add(Calendar.HOUR, SESSION_LIFE_TIME);
            session.setLifeTime(calendar.getTime());
            sessionsRepo.save(session);

            UserDto userDto = modelMapper.map(userDetails.getUser(), UserDto.class);
            userDto.setToken(session.getToken());

            return userDto;
        } catch (UsernameNotFoundException e) {
            throw new AuthenticationErrorException(AUTHENTICATION_ERROR_MESSAGE);
        }
    }

    public Session getValidSessionByToken(String token) {
        Optional<Session> optionalSession = sessionsRepo.findByTokenAndLifeTimeGreaterThan(token, new Date());
        if (optionalSession.isEmpty()) throw new AuthenticationErrorException(AUTHENTICATION_ERROR_MESSAGE);
        Session session = optionalSession.get();
        Calendar calendar = Calendar.getInstance();
        session.setLastActivityTime(calendar.getTime());
        calendar.add(Calendar.HOUR, SESSION_LIFE_TIME);
        session.setLifeTime(calendar.getTime());
        sessionsRepo.save(session);
        return session;
    }

    public void validateToken(String token) {
        Optional<Session> sessionOptional = sessionsRepo.findByTokenAndLifeTimeGreaterThan(token, new Date());
        if (sessionOptional.isEmpty()) throw new AuthenticationErrorException(AUTHENTICATION_ERROR_MESSAGE);

    }
}
