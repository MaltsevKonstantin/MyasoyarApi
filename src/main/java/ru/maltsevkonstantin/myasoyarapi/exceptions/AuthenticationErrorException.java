package ru.maltsevkonstantin.myasoyarapi.exceptions;

public class AuthenticationErrorException extends RuntimeException{

    public AuthenticationErrorException(String msg) {
        super(msg);
    }
}
