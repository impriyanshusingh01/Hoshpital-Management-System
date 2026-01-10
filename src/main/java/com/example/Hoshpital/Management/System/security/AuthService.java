package com.example.Hoshpital.Management.System.security;

import com.example.Hoshpital.Management.System.entity.User;
import com.example.Hoshpital.Management.System.modal.LoginUserDto;
import com.example.Hoshpital.Management.System.modal.SignupUserDto;
import com.example.Hoshpital.Management.System.modal.TokenResponseDto;
import com.example.Hoshpital.Management.System.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public SignupUserDto signup(SignupUserDto userDto){
        User user = authRepository.findByUsername(userDto.getUsername()).orElse(null);
        if(user != null){
            throw new IllegalArgumentException("user already exist");
        }
        user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        User user1 = authRepository.save(user);
        return new SignupUserDto(user1.getId(),user1.getUsername());
    }

    public TokenResponseDto login(LoginUserDto loginUserDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUserDto.getUsername(), loginUserDto.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        String token = jwtUtil.generateAccessToken(user);
        return new TokenResponseDto(token, user.getId());
    }
}
