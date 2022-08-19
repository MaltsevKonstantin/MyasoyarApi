package ru.maltsevkonstantin.myasoyarapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class TokenGenerator {
    PasswordEncoder encoder;

    @Autowired
    public TokenGenerator(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public String generate(String base) {
        return encoder.encode(base);
    }
}
