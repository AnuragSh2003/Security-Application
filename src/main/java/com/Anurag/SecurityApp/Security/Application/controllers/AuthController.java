package com.Anurag.SecurityApp.Security.Application.controllers;

import com.Anurag.SecurityApp.Security.Application.dto.LoginDto;
import com.Anurag.SecurityApp.Security.Application.dto.LoginResponseDto;
import com.Anurag.SecurityApp.Security.Application.dto.SignUpDto;
import com.Anurag.SecurityApp.Security.Application.dto.UserDto;
import com.Anurag.SecurityApp.Security.Application.entities.User;
import com.Anurag.SecurityApp.Security.Application.services.AuthService;
import com.Anurag.SecurityApp.Security.Application.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto){
        UserDto  userDto = userService.signUp(signUpDto);
        return ResponseEntity.ok(userDto);

    }
    @PostMapping("/login")
    public  ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto , HttpServletRequest request , HttpServletResponse response){
        LoginResponseDto loginResponseDto = authService.login(loginDto);

        Cookie cookie = new Cookie("refreshToken",loginResponseDto.getRefreshToken());
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseEntity.ok(loginResponseDto);
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponseDto> refresh(HttpServletRequest request){
      String refreshToken =  Arrays.stream(request.getCookies()).
               filter(cookie -> "refreshToken".equals(cookie.getName()))
               .findFirst()
               .map(Cookie::getValue)
               .orElseThrow(()-> new AuthenticationServiceException("refresh token not found inside the cookie"));
      LoginResponseDto loginResponseDto = authService.refreshToken(refreshToken);
        return ResponseEntity.ok(loginResponseDto);
    }

}
