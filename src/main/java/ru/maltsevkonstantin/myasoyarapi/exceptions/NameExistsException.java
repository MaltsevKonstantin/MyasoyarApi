package ru.maltsevkonstantin.myasoyarapi.exceptions;

public class NameExistsException extends RuntimeException{

    public NameExistsException(String msg) {
        super(msg);
    }
}
