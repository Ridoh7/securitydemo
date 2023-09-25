package com.Realistic.security.Auth;

import com.Realistic.security.AutheticationResponse.AuthenticationResponse;
import com.Realistic.security.DTO.Entity.Request.AdminRequest;
import com.Realistic.security.DTO.Entity.Request.TeamRequest;
import com.Realistic.security.DTO.Entity.Team;
import com.Realistic.security.Repository.TeamRepo;
import com.Realistic.security.Service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    public final AuthenticationService service;
    public final TeamService teamService;
    public final TeamRepo teamRepo;
    @PostMapping("/api/v1/auth/register")
    public ResponseEntity<AuthenticationResponse<Object>> register(
            @RequestBody RegisterRequest request
    ){
       return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/auth/login")
    public ResponseEntity<AuthenticationResponse<Object>> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }
    @PostMapping("/register-admin")
    public ResponseEntity<AuthenticationResponse<Object>> register_Admin(
            @RequestBody AdminRequest adminRequest
    ){
        return ResponseEntity.ok(service.register(adminRequest));
    }
    @PostMapping("/team")
    public ResponseEntity<String> register_team(@RequestBody TeamRequest teamRequest)
    {
        return ResponseEntity.ok(teamService.registerTeam(teamRequest));
    }
    @GetMapping("/allTeam")
    public List<Team>listAllTeam(){
        return teamService.listAllTeam();
    }

}
