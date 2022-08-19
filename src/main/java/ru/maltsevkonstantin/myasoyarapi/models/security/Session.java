package ru.maltsevkonstantin.myasoyarapi.models.security;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id")
    User user;

    @Column(name = "token")
    String token;
    @Column(name = "creationtime")
    Date creationDate;
    @Column(name = "lastactivetime")
    Date lastActivityTime;
    @Column(name = "lifetime")
    Date lifeTime;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastActivityTime() {
        return lastActivityTime;
    }

    public void setLastActivityTime(Date lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
    }

    public Date getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(Date lifeTime) {
        this.lifeTime = lifeTime;
    }
}
