package com.example.Hoshpital.Management.System.controller;

import com.example.Hoshpital.Management.System.modal.LoginUserDto;
import com.example.Hoshpital.Management.System.modal.SignupUserDto;
import com.example.Hoshpital.Management.System.modal.TokenResponseDto;
import com.example.Hoshpital.Management.System.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<SignupUserDto> signup(@RequestBody SignupUserDto signupUserDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.signup(signupUserDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody LoginUserDto loginUserDto){
        return ResponseEntity.ok(authService.login(loginUserDto));
    }
}
