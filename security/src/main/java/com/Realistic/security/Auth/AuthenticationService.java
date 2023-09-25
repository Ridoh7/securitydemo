package com.Realistic.security.Auth;

import com.Realistic.security.AutheticationResponse.AuthenticationResponse;
import com.Realistic.security.Config.JwtService;
import com.Realistic.security.DTO.Entity.Request.AdminRequest;
import com.Realistic.security.DTO.Entity.Request.TeamRequest;
import com.Realistic.security.DTO.Entity.Team;
import com.Realistic.security.Repository.AdminRepo;
import com.Realistic.security.Repository.TeamRepo;
import com.Realistic.security.Repository.UserRepo;
import com.Realistic.security.User.Admin;
import com.Realistic.security.User.Role;
import com.Realistic.security.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepo repo;
    private final AdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse<Object> register(RegisterRequest request) {
        var user= User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repo.save(user);

        var jwtToken= jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse<Object> register(AdminRequest request) {
        var admin = Admin.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN) // Assign the "ADMIN" role
                .build();
        adminRepo.save(admin);


        var jwtToken= jwtService.generateToken(admin);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse<Object> authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user =repo.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }
}
