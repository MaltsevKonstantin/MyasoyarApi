package ru.maltsevkonstantin.myasoyarapi.dto;

import ru.maltsevkonstantin.myasoyarapi.models.security.UserAuthorities;

import java.util.Date;
import java.util.List;

public class UserDto {

    private int id;
    private String login;
    private String token;
    private String name;
    private String password;
    private Date dateCreation;
    private boolean blocked;
    private List<AuthorityDto> authorities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public List<AuthorityDto> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<AuthorityDto> authorities) {
        this.authorities = authorities;
    }

    public static class AuthorityDto {
        private UserAuthorities authority;

        public UserAuthorities getAuthority() {
            return authority;
        }

        public void setAuthority(UserAuthorities authority) {
            this.authority = authority;
        }
    }
}
