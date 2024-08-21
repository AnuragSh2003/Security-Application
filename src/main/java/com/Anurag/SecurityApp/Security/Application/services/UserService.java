package com.Anurag.SecurityApp.Security.Application.services;

import com.Anurag.SecurityApp.Security.Application.exceptions.ResourceNotFoundException;
import com.Anurag.SecurityApp.Security.Application.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(()->new ResourceNotFoundException("User with email "+ username+"not found"));
    }
}
