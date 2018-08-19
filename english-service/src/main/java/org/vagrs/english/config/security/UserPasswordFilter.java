package org.vagrs.english.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.vagrs.english.common.Constants;
import org.vagrs.english.common.JwtUtil;
import org.vagrs.english.model.db.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kirill Zhitelev on 13.05.2018.
 */
public class UserPasswordFilter extends UsernamePasswordAuthenticationFilter {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            final User user = objectMapper.readValue(request.getInputStream(), User.class);

            final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    user.getUserName(), user.getPassword()
            );

            return getAuthenticationManager().authenticate(token);
        } catch (IOException e) {
            throw new InternalAuthenticationServiceException("Error while sign in", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult)
            throws IOException, ServletException {

        final String jwtToken = JwtUtil.generateToken(((org.springframework.security.core.userdetails.User)
                authResult.getPrincipal()).getUsername());

        response.addHeader(Constants.AUTH_HEADER, Constants.HEADER_PREFIX + jwtToken);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        if (failed instanceof BadCredentialsException || failed.getCause() instanceof BadCredentialsException) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType(MediaType.APPLICATION_JSON.getType());
            objectMapper.writeValue(response.getWriter(), Constants.BAD_CRED);
        }
    }
}
