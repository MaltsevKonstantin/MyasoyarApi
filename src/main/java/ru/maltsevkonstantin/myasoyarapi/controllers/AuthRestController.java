package ru.maltsevkonstantin.myasoyarapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.maltsevkonstantin.myasoyarapi.dto.AuthenticationDto;
import ru.maltsevkonstantin.myasoyarapi.dto.UserDto;
import ru.maltsevkonstantin.myasoyarapi.exceptions.AuthenticationErrorException;
import ru.maltsevkonstantin.myasoyarapi.dto.ErrorResponse;
import ru.maltsevkonstantin.myasoyarapi.services.SessionsService;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

    SessionsService sessionsService;

    @Autowired
    public AuthRestController(SessionsService sessionsService) {
        this.sessionsService = sessionsService;
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody AuthenticationDto authenticationDto) {
        UserDto userDto = sessionsService.createSession(authenticationDto);
        return userDto;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> authenticationError(AuthenticationErrorException e) {
        ErrorResponse response = new ErrorResponse();
        response.setTimestamp(System.currentTimeMillis());
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
