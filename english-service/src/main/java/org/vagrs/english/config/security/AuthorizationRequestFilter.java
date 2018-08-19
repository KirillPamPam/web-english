package org.vagrs.english.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.vagrs.english.common.Constants;
import org.vagrs.english.common.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Kirill Zhitelev on 02.06.2018.
 */
public class AuthorizationRequestFilter extends OncePerRequestFilter {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader(Constants.AUTH_HEADER);


        if (authHeader != null && authHeader.startsWith(Constants.HEADER_PREFIX)) {
            final String token = authHeader.substring(7);
            if (JwtUtil.isTokenExpired(token)) {
                response.setStatus(HttpStatus.FORBIDDEN.value());
                response.setContentType(MediaType.APPLICATION_JSON.getType());
                objectMapper.writeValue(response.getWriter(), Constants.ACCESS_DENIED);
            } else {
                final String userName = JwtUtil.getSubject(token);
                if (userName != null) {
                    final UsernamePasswordAuthenticationToken authentication
                            = new UsernamePasswordAuthenticationToken(userName, null, new ArrayList<>());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }

        } else {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }

        filterChain.doFilter(request, response);
    }
}
