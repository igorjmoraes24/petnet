package com.petnet.petnet.security;

import com.petnet.petnet.User.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    // DTOs em formato record (Java 17+)
    public record LoginRequest(String email, String senha) {}
    public record LoginResponse(String token, Long userId, String nome, String email) {}

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.senha())
        );

        User user = (User) auth.getPrincipal();
        String token = jwtService.gerarToken(user);

        return ResponseEntity.ok(new LoginResponse(token, user.getId(), user.getNome(), user.getEmail()));
    }
}