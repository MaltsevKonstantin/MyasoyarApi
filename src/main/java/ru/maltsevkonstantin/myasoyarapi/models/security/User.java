package ru.maltsevkonstantin.myasoyarapi.models.security;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty
    //@Min(value = 5, message = "ФИО пользователя не может быть меньше 5 знаков.")
    private String name;

    @Column(name = "login")
    @NotEmpty
    //@Min(value = 5, message = "Длина логина не может быть меньше 5 знаков.")
    private String login;

    @Column(name = "password")
    @NotEmpty
    //@Min(value = 8, message = "Длина пароля не может быть меньше 8 знаков.")
    private String password;

    @Column(name = "datecreation")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateCreation;

    @Column(name = "blocked")
    private boolean blocked;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Authority> authorities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date createDate) {
        this.dateCreation = createDate;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Entity
    @Table(name = "usersauthorities")
    public static class Authority {
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(name = "userid", referencedColumnName = "id")
        private User user;

        @Enumerated(EnumType.STRING)
        private UserAuthorities authority;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public UserAuthorities getAuthority() {
            return authority;
        }

        public void setAuthority(UserAuthorities authority) {
            this.authority = authority;
        }
    }
}
