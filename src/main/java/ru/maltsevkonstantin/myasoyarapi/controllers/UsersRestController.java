package ru.maltsevkonstantin.myasoyarapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.maltsevkonstantin.myasoyarapi.dto.SuccessResponse;
import ru.maltsevkonstantin.myasoyarapi.dto.UserDto;
import ru.maltsevkonstantin.myasoyarapi.dto.ErrorResponse;
import ru.maltsevkonstantin.myasoyarapi.exceptions.UserWithThisLoginExistsException;
import ru.maltsevkonstantin.myasoyarapi.models.security.User;
import ru.maltsevkonstantin.myasoyarapi.models.security.UserAuthorities;
import ru.maltsevkonstantin.myasoyarapi.services.UsersService;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersRestController {

    private UsersService usersService;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsersRestController(UsersService usersService, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.usersService = usersService;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        createAdminIfUserListEmpty();
    }

    @GetMapping
    public List<UserDto> usersList() {
        return usersService.findAll().stream().map(this::convertToUserDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{login}")
    public UserDto user(@PathVariable String login) {
        Optional<User> user = usersService.findByLogin(login);
        if (user.isEmpty()) return new UserDto();
        user.get().setPassword(null);
        return convertToUserDto(user.get());
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> save(@RequestBody UserDto userDto) {
        User user = convertToUser(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersService.save(user);
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setTimestamp(System.currentTimeMillis());
        successResponse.setMessage("Сохранено успешно.");
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    private UserDto convertToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
    private User convertToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    private void createAdminIfUserListEmpty() {
        try {
            if (usersService.findAll().isEmpty()) {
                User user = new User();
                user.setName("Администратор");
                user.setLogin("admin");
                String password = "12345678";
                user.setPassword(passwordEncoder.encode(password));
                user.setBlocked(false);
                user.setDateCreation(new Date());
                User.Authority authority = new User.Authority();
                authority.setUser(user);
                authority.setAuthority(UserAuthorities.USERS_EDITOR);
                user.setAuthorities(Collections.singletonList(authority));
                usersService.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> userWithThisLoginExistsError(UserWithThisLoginExistsException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(System.currentTimeMillis());
        errorResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
