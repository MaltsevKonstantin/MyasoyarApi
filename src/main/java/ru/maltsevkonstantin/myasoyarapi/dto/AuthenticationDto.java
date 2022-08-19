package ru.maltsevkonstantin.myasoyarapi.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AuthenticationDto {
    @NotEmpty(message = "Логин не может быть пустым.")
    @Size(min = 5, max = 20, message = "Длина логина должна быть от 5 до 20 символов.")
    String login;

    @NotEmpty(message = "Пароль не может быть пустым")
    @Size(min = 8, message = "Пароль должен быть не короче 8 символов.")
    String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
