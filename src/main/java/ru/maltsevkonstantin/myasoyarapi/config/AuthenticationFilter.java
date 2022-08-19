package ru.maltsevkonstantin.myasoyarapi.config;

import antlr.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.maltsevkonstantin.myasoyarapi.exceptions.AuthenticationErrorException;
import ru.maltsevkonstantin.myasoyarapi.models.security.Session;
import ru.maltsevkonstantin.myasoyarapi.security.MyasoyarUserDetails;
import ru.maltsevkonstantin.myasoyarapi.services.SessionsService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter extends OncePerRequestFilter {

    SessionsService sessionsService;

    public AuthenticationFilter(SessionsService sessionsService) {
        this.sessionsService = sessionsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorisation");

        if (token == null || token.isBlank()) response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Ошибка аутентификации.");
        else {
            try {
                Session session = sessionsService.getValidSessionByToken(token);
                MyasoyarUserDetails userDetails = new MyasoyarUserDetails(session.getUser());
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities()
                );
                if (SecurityContextHolder.getContext().getAuthentication() == null) {
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            } catch (AuthenticationErrorException e) {
                if (!response.isCommitted())
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            }
        }

        doFilter(request, response, filterChain);
    }
}
