package ru.maltsevkonstantin.myasoyarapi.exceptions;

public class UserWithThisLoginExistsException extends RuntimeException{

    public UserWithThisLoginExistsException(String msg) {
        super(msg);
    }
}
