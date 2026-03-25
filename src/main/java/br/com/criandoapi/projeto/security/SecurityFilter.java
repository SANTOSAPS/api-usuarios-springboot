package br.com.criandoapi.projeto.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class SecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        if (request.getHeader("Authorization") != null) {
            try {
                Authentication auth = TokenUtil.validate(request);

                if (auth != null) {
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }

            } catch (Exception e) {
                System.out.println("Erro no token: " + e.getMessage());
            }
        }
        filterChain.doFilter(request, response);
    }
}
