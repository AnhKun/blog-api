package com.springboot.blog.controllers;

import com.springboot.blog.dtos.JwtAuthResponseDTO;
import com.springboot.blog.dtos.LoginDto;
import com.springboot.blog.dtos.RegisterDto;
import com.springboot.blog.services.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final IAuthService authService;

    // build login rest api
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponseDTO> login(@RequestBody LoginDto loginDto) {
        String token = authService.login(loginDto);

        JwtAuthResponseDTO jwtAuthResponse = new JwtAuthResponseDTO();
        jwtAuthResponse.setAccessToken(token);

        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
