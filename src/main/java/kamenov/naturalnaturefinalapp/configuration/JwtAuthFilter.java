package kamenov.naturalnaturefinalapp.configuration;


import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import kamenov.naturalnaturefinalapp.repositories.UserRepository;
import kamenov.naturalnaturefinalapp.service.JwtService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public JwtAuthFilter(JwtService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7); // Премахваме "Bearer "
            try {
                // Проверка на валидността на токена
                Claims claims = jwtService.extractClaims(token);
                if (claims.getExpiration().before(new Date())) {
                    // Токенът е изтекъл
                    logger.warn("JWT Token has expired");
                    filterChain.doFilter(request, response);
                    return;
                }

                // Извличане на потребителски данни от токена
                UserDetails userDetails = jwtService.extractUserFromToken(token);
                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception e) {
                logger.error("JWT validation failed: " + e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }
}


//@Component
//public class JwtAuthFilter extends OncePerRequestFilter {
//    private final JwtService jwtService;
//    private final UserRepository userRepository;
//
//    public JwtAuthFilter(JwtService jwtService, UserRepository userRepository) {
//        this.jwtService = jwtService;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        String authHeader = request.getHeader("Authorization");
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            String token = authHeader.substring(7); // Премахваме "Bearer "
//            UserDetails userDetails = jwtService.extractUserFromToken(token);
//            if (userDetails != null) {
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                        userDetails, null, userDetails.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//        filterChain.doFilter(request, response);
//    }


//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain) throws ServletException, IOException, IOException {
//
//        final String authHeader = request.getHeader("Authorization");
//
//        //Authorization: Bearer <token>
//        if (authHeader == null ||
//                authHeader.isBlank() ||
//                !authHeader.startsWith("Bearer ")
//        ) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String jwtToken = authHeader.substring(7);
//
//        UserDetails userDetails = jwtService.extractUserFromToken(jwtToken);
//
//        if (SecurityContextHolder.getContext().getAuthentication() == null) {
//            SecurityContext context = SecurityContextHolder.getContext();
//
//            UsernamePasswordAuthenticationToken authenticationToken =
//                    new UsernamePasswordAuthenticationToken(
//                            userDetails,
//                            "",
//                            userDetails.getAuthorities()
//                    );
//            context.setAuthentication(authenticationToken);
//            SecurityContextHolder.setContext(context);
//        }
//
//        filterChain.doFilter(request, response);
//    }

