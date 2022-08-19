package ru.maltsevkonstantin.myasoyarapi.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.maltsevkonstantin.myasoyarapi.models.security.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyasoyarUserDetails implements UserDetails {

    User user;

    public MyasoyarUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        for (User.Authority authority: user.getAuthorities()) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority.getAuthority().toString());
            grantedAuthorityList.add(simpleGrantedAuthority);
        }
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isBlocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }
}
