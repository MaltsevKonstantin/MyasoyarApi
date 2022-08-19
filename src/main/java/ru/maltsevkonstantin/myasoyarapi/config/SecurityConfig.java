package ru.maltsevkonstantin.myasoyarapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.maltsevkonstantin.myasoyarapi.services.MyasoyarUserDetailsService;
import ru.maltsevkonstantin.myasoyarapi.services.SessionsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    MyasoyarUserDetailsService service; //Нужен ли этот сервис здесь?
    SessionsService sessionsService;

    @Autowired
    public SecurityConfig(MyasoyarUserDetailsService service, SessionsService sessionsService) {
        this.service = service;
        this.sessionsService = sessionsService;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                //.authorizeRequests()
                    //.antMatchers(HttpMethod.POST, "/auth/login").permitAll()
                    //.antMatchers("/users").hasAuthority(UserAuthorities.USERS_EDITOR.toString())
                //.and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)     //Не использовать сессии Spring Security
                //.and()
                //.addFilterBefore(new AuthenticationFilter(sessionsService), UsernamePasswordAuthenticationFilter.class)
                //.anonymous()
        ;

        SecurityFilterChain securityFilterChain = http.build();
        return securityFilterChain;
    }
}
