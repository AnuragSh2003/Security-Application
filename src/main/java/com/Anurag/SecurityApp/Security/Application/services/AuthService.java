package com.Anurag.SecurityApp.Security.Application.services;

import com.Anurag.SecurityApp.Security.Application.dto.LoginDto;
import com.Anurag.SecurityApp.Security.Application.entities.User;
import com.Anurag.SecurityApp.Security.Application.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService{
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final UserRepository userRepository;

    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        return jwtService.generateToken(user);
    }
}
